package com.tbtaobao.cloud.result;

import com.tbtaobao.cloud.constants.CodeConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ：taoyl
 * @date ：Created in 2020-05-31 20:03
 * @description：
 */
@Data
@AllArgsConstructor
public class ServiceResult {

    private Integer status;
    private String message;
    private Object data;

    public ServiceResult() {
        this.status = CodeConstant.SUCCESS;
    }

    public ServiceResult(String message) {
        this.status = CodeConstant.ERROR;
        this.message = message;
    }

    public ServiceResult(Object data) {
        this.status = CodeConstant.SUCCESS;
        this.data = data;
    }
}
