package com.jas.eurekaconsumer.feign;

import com.jas.eurekaconsumer.feign.fallback.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 琚安生
 * @since 设计wiki | 需求wiki
 */
@FeignClient(serviceId = "eureka-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/hello/say/{msg}")
    public String sayHello(@PathVariable(name = "msg") String msg);

}
