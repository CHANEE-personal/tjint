package com.tjint.springboot.common;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.Serializable;

public class CommonVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String returnCode;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString((Object)this);
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(final String returnCode) {
        this.returnCode = returnCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CommonVo)) {
            return false;
        }
        final CommonVo other = (CommonVo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        final Object this$returnCode = this.getReturnCode();
        final Object other$returnCode = other.getReturnCode();
        if (this$returnCode == null) {
            if (other$returnCode == null) {
                return true;
            }
        }
        else if (this$returnCode.equals(other$returnCode)) {
            return true;
        }
        return false;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommonVo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $returnCode = this.getReturnCode();
        result = result * 59 + (($returnCode == null) ? 43 : $returnCode.hashCode());
        return result;
    }
}
