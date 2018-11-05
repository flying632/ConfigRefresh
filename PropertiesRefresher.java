package com.norland.suwp.keygen.eureka;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;

import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author fengyuluo
 * @createTime 10:20 2018/10/31
 */
@Slf4j
@Component
public class PropertiesRefresher implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Autowired
    RefreshScope refreshScope;

    @ApolloConfigChangeListener("suwp-commonms-dev")
    public void onChange(ConfigChangeEvent changeEvent){
//         boolean eurekaPropertiesChanged = false;
//         for (String changedKey : changeEvent.changedKeys()) {
//             if (changedKey.startsWith("eureka.")) {
//                 log.info("===============================================================");
//                 log.info("changedKey:{} value:{}",changedKey,changeEvent.getChange(changedKey));
//                 ConfigChange configChange = changeEvent.getChange(changedKey);
//                 configChange.getOldValue();
//                 eurekaPropertiesChanged = true;
//                 break;
//             }
//         }
        refreshProperties(changeEvent);
//        if (eurekaPropertiesChanged) {
//            refreshEurekaProperties(changeEvent);
//        }
    }
    public void refreshProperties(ConfigChangeEvent changeEvent){
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
        refreshScope.refreshAll();
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
