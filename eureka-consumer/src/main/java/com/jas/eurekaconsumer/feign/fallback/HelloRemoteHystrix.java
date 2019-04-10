package com.jas.eurekaconsumer.feign.fallback;

import com.jas.eurekaconsumer.feign.HelloRemote;
import org.springframework.stereotype.Component;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 琚安生
 * @since 设计wiki | 需求wiki
 */
@Component
public class HelloRemoteHystrix implements HelloRemote{
    @Override
    public String sayHello(String msg) {
        return "hello failed message " + msg;
    }
}
