package com.stone.rest.play.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {

    private boolean success;

    private String code;

    private String message;

}
