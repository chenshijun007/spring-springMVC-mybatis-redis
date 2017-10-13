package com.hanboard.source;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class DataSourceAspect {
    private final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    public DataSourceAspect() {
    }


    @Before("@annotation(com.hanboard.source.DataSource)")
    public void before(JoinPoint point) {
        Method method = ((MethodSignature)point.getSignature()).getMethod();
        DataSource dataSource = (DataSource)method.getAnnotation(DataSource.class);
        this.logger.info("切换数据源为：{}", dataSource.value());
        HandleDataSource.putDataSource(dataSource.value());
    }
}
