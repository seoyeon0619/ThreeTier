package com.ds;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

// Config 지정을 위한 어노테이션
// 정해진 파일명과 클래스명은 없음
@Configuration
public class MybatisConfig {

	@Bean // 객체 생성
	public SqlSessionFactory makeSqlSessionFactory(DataSource dataSource) throws Exception
	{
		System.out.println("***************************");
		// sqlSessionFactory : Factory
		final SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		
		// 객체와 application.properties 파일에 있는 dataSource와 연결
		factory.setDataSource(dataSource);
		// 설정파일과 연동 (mybatis-config.xml)
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		// classpath - src/main/resource
		Resource configLocation = resolver.getResource("classpath:mybatis-config.xml"); 
		
		factory.setConfigLocation(configLocation);
		return factory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate makeSqlSession(SqlSessionFactory factory)
	{
		return new SqlSessionTemplate(factory);
	}
}