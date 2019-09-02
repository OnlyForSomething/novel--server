package com.getnovel.user.pojo;

import com.getnovel.common.Constants;
import com.getnovel.common.annotation.EncryptField;
import com.getnovel.common.validate.interfaceGroup.BeforeRegexp;
import com.getnovel.common.validate.interfaceGroup.Insert;
import com.getnovel.common.validate.interfaceGroup.Oauth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


public class User {

    private Integer userId;
    /**
     * 不分配groups 每个添加@validated注解的都校验
     */
    @NotEmpty(message = "账号未填写",groups = {Oauth.class,BeforeRegexp.class})
    private String account;
    @NotEmpty(message = "密码未填写",groups = {Oauth.class,BeforeRegexp.class})
    @EncryptField
    private String password;
    /**
     * 分配groups 在添加@Validated({xxx.class})时验证此类中分配了groups = {xxx.class}的属性
     */
    @NotEmpty(message = "手机号未填写",groups = {BeforeRegexp.class})
    @Pattern(message = "手机号不存在",regexp = Constants.phoneRegexp,groups = {Insert.class})
    @EncryptField
    private String phone;
    @NotEmpty(message = "邮箱未填写",groups = {BeforeRegexp.class})
    @EncryptField
    @Email(message = "邮箱格式不正确" ,regexp= Constants.emailRegexp,groups = {Insert.class})
    private String email;
    private String userType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
