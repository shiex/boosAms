package com.xbb.bo;

import com.xbb.utils.FileUploadUtils;

/**
 * @author shiex-薛
 * @title: FileUploadBO
 * @projectName ax-blog
 * @description: TODO
 * @date 2019\8\5 00050:05
 */
public class FileUploadBO {

    private String originalFilename;
    private String suffix;
    private String tmpFileName;

    private FileUploadBO(){}

    public FileUploadBO(String originalFilename){
        this.originalFilename = originalFilename;
        this.suffix = FileUploadUtils.fileSuffix(this.originalFilename);
        this.tmpFileName = FileUploadUtils.createTmpFileName(this.suffix);
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTmpFileName() {
        return tmpFileName;
    }

}
