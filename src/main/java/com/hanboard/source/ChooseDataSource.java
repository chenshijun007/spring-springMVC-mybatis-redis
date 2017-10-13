package com.hanboard.source;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class ChooseDataSource extends AbstractRoutingDataSource {
    private final Logger logger = LoggerFactory.getLogger(ChooseDataSource.class);

    public ChooseDataSource() {
    }

    protected Object determineCurrentLookupKey() {
        String dataSource = HandleDataSource.getDataSource();
        HandleDataSource.removeDataSource();
        if(StringUtils.isEmpty(dataSource)) {
            this.logger.info("使用默认数据源！！");
        } else {
            this.logger.info("使用数据源：{}", dataSource);
        }

        return dataSource;
    }
}
