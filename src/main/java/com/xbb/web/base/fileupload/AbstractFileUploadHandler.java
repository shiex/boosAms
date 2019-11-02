package com.xbb.web.base.fileupload;


import com.xbb.web.base.QueryParams;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;

public abstract class AbstractFileUploadHandler {

    public boolean enableErrorLog = false;
    // httpReq : 请求对象
    protected HttpServletRequest httpReq;
    // httpResp : 应答对象
    protected HttpServletResponse httpResp;
    // queryParams : URL 末属附加的参数
    protected QueryParams queryParams;
    // charset： 字符编码
    protected String charset;

    // 上传前准备
    protected abstract OutputStream uploadStarted(String originalFileName) throws Exception;

    // 上传中检查 (可做文件大小上限的检测) numBytes: 已上传的字节数
    protected abstract void uploadProgress(long numBytes) throws Exception;

    // 上传后调用 fileSize表示已上传字节数
    protected abstract Object uploadComplete(long fileSize) throws Exception;

    // 上传过程中发生错误
    protected abstract void uploadError();

    //////////////////////////////////
    protected File getWebRoot() {
        if (httpReq == null) {
            System.out.println("API用法出错: 请在 uploadStarted()调用getWebRoot()!!!");
            return null;
        }

        String path = httpReq.getServletContext().getRealPath("/");
        return new File(path);
    }


}
