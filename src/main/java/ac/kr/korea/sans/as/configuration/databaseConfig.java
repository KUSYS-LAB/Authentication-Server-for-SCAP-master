package ac.kr.korea.sans.as.configuration;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "ac.kr.korea.sans.as.dao")
@EnableTransactionManagement
public class databaseConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return sessionFactory.getObject();
	}
	@Bean
	public SqlSessionTemplate sqlSessionTemplatr(SqlSessionFactory sqlSessionFactory) {
		final SqlSessionTemplate sqlSessionTemplate
		=new SqlSessionTemplate(sqlSessionFactory);
		return sqlSessionTemplate;
		
		
	}
	
	
	
	
}