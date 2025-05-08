package edu.GDPU.Demo.Common.dto;

/**
 * 统一API响应结果封装类
 * 默认状态码20000表示成功，其他数值表示不同类型的错误
 */
public class Result {
    /**
     * 响应状态码（20000=成功）
     */
    private int code = 20000;

    /**
     * 响应提示信息（成功时默认"ok"，错误时返回具体原因）
     */
    private String message = "ok";

    /**
     * 响应携带的业务数据（成功时返回查询结果，失败时为null）
     */
    private Object data;

    /**
     * 默认构造器（用于成功无数据返回场景）
     */
    public Result() {
    }

    /**
     * 错误响应构造器
     *
     * @param code    自定义错误码（与前端约定）
     * @param message 错误提示信息
     */
    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功响应构造器
     *
     * @param data 需要返回的业务数据对象
     */
    public Result(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
