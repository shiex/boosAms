package com.xbb.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @author shiex-薛
 * @title: C3P0DataSourceFactory
 * @projectName book-ams
 * @description: TODO
 * @date 2019\8\25 002515:03
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {
    public C3P0DataSourceFactory(){
        this.dataSource = new ComboPooledDataSource();
    }
}
