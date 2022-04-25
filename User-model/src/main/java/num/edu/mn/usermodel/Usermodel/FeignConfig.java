//package num.edu.mn.usermodel.Usermodel;
//
//import feign.Contract;
//import feign.Logger;
//import org.sonarsource.scanner.api.internal.shaded.okhttp.OkHttpClient;
//import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.openfeign.FeignAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableFeignClients()
//@ImportAutoConfiguration({FeignAutoConfiguration.class})
//public class FeignConfig
//{
//
//    @Bean
//    public OkHttpClient client() {
//        return new OkHttpClient();
//    }
//
//    @Bean
//    public Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }
//
//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }
//}
