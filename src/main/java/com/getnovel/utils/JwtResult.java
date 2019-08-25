package com.getnovel.utils;

import io.jsonwebtoken.Claims;

public  class JwtResult{
    private boolean status;
    private Claims claims;
    private String msg;
    private  int code;

    public JwtResult() {
        super();
    }

    public JwtResult(boolean status, Claims claims,String msg, int code) {
        super();
        this.status = status;
        this.claims=claims;
        this.msg = msg;
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Claims getClaims() {
        return claims;
    }

    public void setClaims(Claims claims) {
        this.claims = claims;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "JwtResult{" +
                "status=" + status +
                ", claims='" + claims + '\'' +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                '}';
    }
}