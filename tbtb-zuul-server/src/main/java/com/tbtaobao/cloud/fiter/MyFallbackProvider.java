package com.tbtaobao.cloud.fiter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author ：taoyl
 * @date ：Created in 2020-06-20 17:12
 * @Component 这个注解就是说将它注册到服务中去(也就是spring容器中)
 *它和@Bean 大同小异  @Bean也是注册到spring容器中,只不过它是基于配置类使用
 *再加上 @Configuration 注解就行了
 **/
@Component
public class MyFallbackProvider implements FallbackProvider {

    //这个就是控制所有服务经过网关访问时可能出现的异常捕捉
    @Override
    public String getRoute() {
        // 表明是为哪个微服务提供回退，*表示为所有微服务提供回退
        return "*";
    }


    //重写回退方法体
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }
            //这个就是控制全局异常的核心方法
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务故障，请稍后重试!".getBytes());
            }
            //设置编码为utf-8
            @Override
            public HttpHeaders getHeaders() {
                // headers设定
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }

}
