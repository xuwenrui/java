package com.frank.handdler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 28.1.11错误处理
 * @author: xu.wr
 * @create: 2019-03-14 14:30
 **/

/**
 * 统一异常处理方法之一：
 * 使用@ControllerAdvice注解，继承ResponseEntityExceptionHandler类
 * 只要在方法上throws YourException 即可被捕获（一般在controller下一层处理），
 * 返回到也没为json。如：{"result":500,"message":"It's not Frank"}
 */
@ControllerAdvice
public class AcmeControllerAdvice extends ResponseEntityExceptionHandler {
    //自定义Exception
    @ExceptionHandler(YourException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorType(status.value(), ex.getMessage()), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
