package com.xbb.web.servlet;

import com.alibaba.fastjson.JSONObject;
import com.xbb.utils.FileUploadUtils;
import com.xbb.web.base.fileupload.AbstractFileUploadHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PhotoFileUpload extends AbstractFileUploadHandler {

    private static Logger log = LoggerFactory.getLogger(PhotoFileUpload.class);

    String originalFileName; // 原始文件名
    String suffix; // 文件后缀
    String tmpFileName; // 临时文件名
    File tmpFile; // 临时文件
    OutputStream out; // 字节输出流

    @Override
    protected Object uploadComplete(long fileSize) throws Exception {
        log.info("完成上传：" + originalFileName);
        // 确保文件句柄被关闭
        try {
            out.close();
        } catch (Exception e) {
        }

        // 返回结果
        String storePath = "/image/" + tmpFileName;  // 图片请求路径
        String photoPath = httpReq.getServletContext().getRealPath("/") + (storePath.substring(1)); // 图片存储路径

        HttpSession session = httpReq.getSession();
        session.setAttribute("imageUri", storePath);

        JSONObject result = new JSONObject();
        result.put("storePath", storePath); // 请求路径
        result.put("photoPath", photoPath); // 存储路径
        return result;
    }

    @Override
    protected void uploadError() {
        // 出错时的善后处理
        // 确保文件句柄被关闭
        try {
            out.close();
        } catch (Exception e) {
        }
    }

    @Override
    protected void uploadProgress(long numBytes) throws Exception {
        // 文件大小判断处理
        if (numBytes > 1000000 * 20)
            throw new Exception("上传文件不得超过20M!");
    }

    @Override
    protected OutputStream uploadStarted(String originalFileName) throws Exception {
        this.originalFileName = originalFileName; // 原始文件名
        this.suffix = FileUploadUtils.fileSuffix(originalFileName); // 后缀
        this.tmpFileName = FileUploadUtils.createUUID() + "." + suffix;

        // 决定把文件存在哪里
        File tmpDir = new File(getWebRoot(), "image");
        this.tmpFile = new File(tmpDir, tmpFileName);
        out = new FileOutputStream(tmpFile); // 打开此文件的字节输出流

        return out;
    }

}
