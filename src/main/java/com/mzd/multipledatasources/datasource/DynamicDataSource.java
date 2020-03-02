package com.mzd.multipledatasources.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

//编写AbstractRoutingDataSource实现类重写方法实现动态切换数据源
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		DataSourceType.DataBaseType dataBaseType = DataSourceType.getDataBaseType();
		return dataBaseType;
	}

}
