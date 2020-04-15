package org.bestsoft.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfigurerAdapterConfig extends WebMvcConfigurationSupport {
    /*@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(fastJsonHttpMessageConverter());
        converters.add(new ByteArrayHttpMessageConverter());
    }*/

   /* @Bean
    public HttpMessageConverter fastJsonHttpMessageConverter() {
        //1、创建FastJson信息转换对象
        FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverterImpl();
        //2、创建FastJsonConfig对象并设定序列化规则  序列化规则详见SerializerFeature类中，后面会讲
        FastJsonConfig fastJsonConfig= new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,SerializerFeature.WriteNonStringKeyAsString);
        //本人就坑在WriteNonStringKeyAsString 将不是String类型的key转换成String类型，否则前台无法将Json字符串转换成Json对象

        //3、中文乱码解决方案
        List<MediaType> fastMedisTypes = new ArrayList<MediaType>();
        fastMedisTypes.add(MediaType.APPLICATION_JSON_UTF8);//设定Json格式且编码为utf-8
        fastConverter.setSupportedMediaTypes(fastMedisTypes);
        //4、将转换规则应用于转换对象
        fastConverter.setFastJsonConfig(fastJsonConfig);
        return fastConverter;
    }*/

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
