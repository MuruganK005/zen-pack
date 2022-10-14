package com.ZenPack;

import com.ZenPack.utils.DataSourceConnection;
import com.ZenPack.utils.ZKModel;
import com.ZenPack.utils.ZookeeperConnection;
import org.apache.zookeeper.KeeperException;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.swing.text.Utilities;
import java.io.IOException;

//
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableSwagger2
@ComponentScan
//@SpringBootApplication
public class ZenPackProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(ZenPackProjectApplication.class, args);
	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ZenPack")).build();
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws IOException, KeeperException, InterruptedException
	{
		ZookeeperConnection zkConnection = new ZookeeperConnection();
		ZKModel.zkData = zkConnection.getZKData();

		Utilities utilites = new Utilities();
		DataSourceConnection dataSource = new DataSourceConnection();

	}
/*	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.serializerByType(PagedList.class, new PagedListSerializer());
		return builder;
	}*/

}