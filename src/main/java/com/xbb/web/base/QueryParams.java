package com.xbb.web.base;

import java.util.Map;

public class QueryParams {
    public Map<String, String> params;

    public QueryParams() {}

    public QueryParams(Map<String, String> params) {
        this.params = params;
    }

    public void put(String key, String value) {
        params.put(key, value);
    }

    // 从参数中取值
    public Integer getInt(String key, Integer defValue) {
        try {
            return Integer.valueOf(params.get(key));
        } catch (Exception e) {
            return defValue;
        }
    }

    public Long getLong(String key, Long defValue) {
        try {
            return Long.valueOf(params.get(key));
        } catch (Exception e) {
            return defValue;
        }
    }

    public Double getDouble(String key, Double defValue) {
        try {
            return Double.valueOf(params.get(key));
        } catch (Exception e) {
            return defValue;
        }
    }

    public String getString(String key, String defValue) {
        try {
            String val = params.get(key);
            if (val != null)
                return val;
        } catch (Exception e) {
        }
        return defValue;
    }

    public Boolean getBoolean(String key, Boolean defValue) {
        try {
            return Boolean.valueOf(params.get(key));
        } catch (Exception e) {
            return defValue;
        }
    }
}
