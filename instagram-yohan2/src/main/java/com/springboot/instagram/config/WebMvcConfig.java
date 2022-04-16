package com.springboot.instagram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration // 설정
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${file.path}")  // application.yml의 file:
	                        // 						 path: C:\fileupload\ 이거임...
	private String filePath;
//	@Value는 @Autowired와 같다. filePath = ${file.path} 이다.
	
	// registry 얘가 설정 객체이다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/image/**")   // 이 요청이 들어오면 밑에 줄이 실행이 된다.
		.addResourceLocations("file:///" + filePath) // 위 주소로 요청했을 떄, 
		// "/image/**" 로 들어온 애들을 => "file:///" + filePath 로 바꾼단다. 
		// => 여기서 filePath = ${file.path}
		.setCachePeriod(60*60) // 캐시 유지시간 3600초, 위의 경로가 1시간 유지 될것이다.
		.resourceChain(true)
		.addResolver(new PathResourceResolver()); // viewResolver랑 같다.
	}
//	registry.addResourceHandler("/image/**") : 주소 입력시에 localhost:800/image/* 이거말함
//	얘는 src/main/resources/static 안에 있는 /images/를 말함
	
}
