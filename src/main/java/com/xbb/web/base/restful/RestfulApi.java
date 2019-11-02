package com.xbb.web.base.restful;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xbb.web.base.exception.WebException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RestfulApi extends AbstractGenericApi {

    private static Logger log = LoggerFactory.getLogger(RestfulApi.class);

    protected boolean printErrHint = true;
    protected boolean niceJSONFormat = true; // 输出的JSON是否综进 (缩进影响运行效率)

    public abstract Object execute(JSONObject jreq) throws Exception;

    @Override
    public String execute(String strReq) throws Exception {
        // 处理请求数据
        JSONObject jresp = new JSONObject();
        try {
            // 读取请求数据, 转成字符串, 转成 JSON
            JSONObject jreq = null;
            if (strReq.length() > 0)
                jreq = JSON.parseObject(strReq);

            Object data = execute(jreq);
            jresp.put("error", 0); // 错误码,0表示成功
            jresp.put("reason", "OK"); // 错误原因描述, 如果没有错误则提示OK
            if (data != null) {
                jresp.put("data", data); //
            }

        } catch (WebException e) {
            jresp.put("error", e.error); // 错误码,0表示成功
            jresp.put("reason", e.getMessage()); // 错误原因描述, 如果没有错误则提示OK

            if (printErrHint)
                log.info("[" + config.name + ".api] [" + e.getClass().getSimpleName() + "] => " + e.getMessage());
            if (debug > 0)
                e.printStackTrace();

        } catch (Exception e) {
            String reason = e.getMessage();
            if (reason == null) reason = e.getClass().getName();

            jresp.put("error", -1); // 错误码,0表示成功
            jresp.put("reason", reason); // 错误原因描述, 如果没有错误则提示OK

            if (printErrHint)
                log.info("[" + config.name + ".api] [" + e.getClass().getSimpleName() + "] => " + e.getMessage());
            if (debug > 0)
                e.printStackTrace();
        }

        // 返回给客户端
        if (niceJSONFormat)
            return jresp.toString(); // 缩进格式
        else
            return jresp.toString();
    }


}
