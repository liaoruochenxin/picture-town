package com.xj.imageback.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.region.Region;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Coe客户端连接配置
 */
@Configuration
@ConfigurationProperties(prefix = "cos.client")
@Data
public class CosClientConfig {
    /**
     * 域名
     */
    private String host;

    /**
     * secretId
     */
    private String secretId;

    /**
     * 密钥（避免泄露）
     */
    private String secretKey;

    /**
     * 区域
     */
    private String region;

    /**
     * 存储桶名
     */
    private String bucket;

    @Bean
    public COSClient cosClient() {
        //初始化用户身份信息(secretId, secretKey)
        BasicCOSCredentials cosCredentials = new BasicCOSCredentials(secretId, secretKey);
        // 设置Bucket区域，简称参考https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        // 生成cos客户端
        return new COSClient(cosCredentials, clientConfig);
    }
}
