package am.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Value("${spring.servlet.multipart.location}")
	private String uploadImagePath;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("GET", "POST", "PUT", "DELETE");
	}
	
	// 이미지 넣기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/outsideImg/**").addResourceLocations("file:///C:/AMPROJECT/outsideImages/");

		//정민
//		registry.addResourceHandler("/images/**").addResourceLocations("file:///C:/java602/outsideImages/");

		String imgPath = "file///" + uploadImagePath;
		
//		registry.addResourceHandler("/outsideImg/**").addResourceLocations("file:///C:/AMPROJECT/outsideImages/");
		registry.addResourceHandler("/outsideImg/**").addResourceLocations(imgPath);
	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/images/**")
//		.addResourceLocations("file:///C:/java602/outsideImages/");
//	}
}
