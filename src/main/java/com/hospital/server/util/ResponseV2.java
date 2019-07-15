package com.hospital.server.util;

import java.beans.ConstructorProperties;

import org.springframework.http.HttpStatus;

public class ResponseV2 {
    private Integer code;
    private String msg;
    private Data data;
    private Integer count;


    @ConstructorProperties({"msg", "code", "data","count"})
    ResponseV2(final String msg, final Integer code, final Data data, final Integer count) {
        this.code = HttpStatus.OK.value();
        this.msg = "请求成功";
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public static ResponseV2Builder builder() {
        return new ResponseV2Builder();
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Data getData() {
        return this.data;
    }

    public Integer getCount(){
        return this.count;
    }

    public void setCode(final Integer status) {
        this.code = status;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final Data result) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResponseV2)) {
            return false;
        } else {
            ResponseV2 other = (ResponseV2)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$status = this.getCode();
                    Object other$status = other.getCode();
                    if (this$status == null) {
                        if (other$status == null) {
                            break label47;
                        }
                    } else if (this$status.equals(other$status)) {
                        break label47;
                    }

                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$result = this.getData();
                Object other$result = other.getData();
                if (this$result == null) {
                    if (other$result != null) {
                        return false;
                    }
                } else if (!this$result.equals(other$result)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseV2;
    }



    public String toString() {
        return "ResponseV2(msg=" + this.getMsg() + ", code=" + this.getCode() + ", data=" + this.getData() + ", count=" + this.getCount()+ ")";
    }

    public static class ResponseV2Builder {
        private Integer code;
        private String msg;
        private Data result;
        private Integer count;

        ResponseV2Builder() {
        }

        public ResponseV2Builder code(final Integer code) {
            this.code = code;
            return this;
        }

        public ResponseV2Builder msg(final String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseV2Builder result(final Data result) {
            this.result = result;
            return this;
        }
        public ResponseV2Builder count(final Integer count) {
            this.count = count;
            return this;
        }

        public ResponseV2 build() {
            return new ResponseV2( this.msg,this.code, this.result,this.count);
        }

        public String toString() {
            return "ResponseV2.ResponseV2Builder(status=" + this.code + ", msg=" + this.msg + ", data=" + this.result +")";
        }
    }
}
