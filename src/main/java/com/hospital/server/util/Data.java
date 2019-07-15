package com.hospital.server.util;

import java.beans.ConstructorProperties;

public class Data<T> {
    private T datas;
    @ConstructorProperties({"datas"})
    Data(final T datas) {
        this.datas = datas;

    }

    public static <T> ResultBuilder<T> builder() {
        return new ResultBuilder();
    }

    public T getDatas() {
        return this.datas;
    }


    public void setDatas(final T datas) {
        this.datas = datas;
    }


    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Data)) {
            return false;
        } else {
            Data<?> other = (Data)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$data = this.getDatas();
                Object other$data = other.getDatas();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Data;
    }


    public String toString() {
        return "data(data=" + this.getDatas();
    }

    public static class ResultBuilder<T> {
        private T datas;

        ResultBuilder() {
        }

        public ResultBuilder<T> datas(final T datas) {
            this.datas = datas;
            return this;
        }

        public Data<T> build() {
            return new Data(this.datas);
        }

        public String toString() {
            return "data=" + this.datas + ")";
        }
    }
}
