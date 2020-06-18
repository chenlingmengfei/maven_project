package com.qf.cl.factory;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;

/**
 * ClassName: DriudDataSourceFactory
 * Description:
 *
 * @author CL
 * @version 1.0
 * @date: 2020/6/18
 */
public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }

}
