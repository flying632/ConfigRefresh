package com.norland.suwp.keygen.eureka;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.discovery.AbstractDiscoveryClientOptionalArgs;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClientConfig;

/**
 * @author fengyuluo
 * @createTime 19:35 2018/11/1
 */
public class PDiscoveryClient extends DiscoveryClient {

    public PDiscoveryClient(ApplicationInfoManager applicationInfoManager, EurekaClientConfig config) {
        super(applicationInfoManager, config);
    }

    public PDiscoveryClient(ApplicationInfoManager applicationInfoManager, EurekaClientConfig config, AbstractDiscoveryClientOptionalArgs args) {
        super(applicationInfoManager, config, args);
    }

    @Override
    public void onCacheRefreshed() {
        super.onCacheRefreshed();
    }
}
