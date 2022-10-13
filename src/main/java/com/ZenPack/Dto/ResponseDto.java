package com.ZenPack.Dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Getter
@Setter
public class ResponseDto {
    private String responseMessage;
    private String responseCode;
    private Integer statusCode;
    private String responseDescription;
    private Object data;
    private ZenPackDto Jdata;
    private Boolean validation=false;


}
