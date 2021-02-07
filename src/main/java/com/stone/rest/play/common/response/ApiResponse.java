package com.stone.rest.play.common.response;

import lombok.Getter;
import lombok.Setter;

/**
 * AipReponse Util
 * @author LYP
 */
@Getter
@Setter
public class ApiResponse<T> extends BaseResponse {

    /**
     * return result response dto
     */
    private T data;

    /**
     * SUCCESS
     * return response data with success code, message
     *
     * @param data
     * @return
     */
    public static <T> ApiResponse<T> of(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data); // response payload
        response.setSuccess(true);
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(ResponseCode.SUCCESS.getMessage());
        return response;
    }

    /**
     * SUCCESS
     * return succes status code, message only
     *
     * @return
     */
    public static ApiResponse<Object> ok() {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(ResponseCode.SUCCESS.getMessage());
        return response;
    }

    /**
     * SUCCESS
     * return succes status with custom message
     *
     * @param message
     * @return
     */
    public static ApiResponse<Object> ok(String message) {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(message);
        return response;
    }

    /**
     * fail
     *
     * @return
     */
    public static ApiResponse<Object> fail() {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setCode(ResponseCode.FAILURE.getCode());
        response.setMessage(ResponseCode.FAILURE.getMessage());
        return response;
    }

    /**
     * fail
     * return custom failure message
     *
     * @param message
     * @return
     */
    public static ApiResponse<Object> fail(String message) {
        ApiResponse<Object> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setCode(ResponseCode.FAILURE.getCode());
        response.setMessage(message);
        return response;
    }

}
