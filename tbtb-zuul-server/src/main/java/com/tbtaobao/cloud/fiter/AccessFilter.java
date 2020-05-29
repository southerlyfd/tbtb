package com.tbtaobao.cloud.fiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tbtaobao.cloud.redis.BaseRedisService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
/**
 * @author ：taoyl
 * @date ：Created in 2020-05-21 21:52
 * @description：
 */
@Component
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    //排除过滤的 uri 地址
    private static final String LOGIN_URI = "/oa/userInfo/login";

    //无权限时的提示语
    private static final String INVALID_TOKEN = "invalid token";

    @Autowired
    private BaseRedisService baseRedisService;

    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 配置过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info("{} >>> {}", request.getMethod(), request.getRequestURL().toString());
        //注册和登录接口不拦截，其他接口都要拦截校验 token
        if (LOGIN_URI.equals(request.getRequestURI())) {
            return null;
        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            logger.warn("token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
            }
        } else {
            String redisToken = baseRedisService.get(token);
            if (StringUtils.isEmpty(redisToken)) {
                logger.warn("redisToken is invalid");
                context.setSendZuulResponse(false);
                context.setResponseStatusCode(401);
                try {
                    context.getResponse().getWriter().write("redisToken is invalid");
                } catch (IOException e) {
                }
            } else {
                logger.info("OK");
                //将头信息传递下去
                context.addZuulRequestHeader("accessToken", token);
            }
        }
        return null;
    }
}
