package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.entity.BlogConfig;
import com.site.blog.my.core.mapper.BlogConfigMapper;
import com.site.blog.my.core.service.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <br>系统配置<br/>
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/20
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    private BlogConfigMapper configMapper;

    @Autowired
    public ConfigServiceImpl(BlogConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    private static final String WEBSITE_NAME = "DIMPLES BLOG";
    private static final String WEBSITE_DESCRIPTION = "个人学习与工作的总结";
    private static final String WEBSITE_LOGO = "/admin/dist/img/logo2.png";
    private static final String WEBSITE_ICON = "/admin/dist/img/logo_zhongyjpng";

    private static final String YOUR_AVATAR = "/admin/dist/img/logo_zhongyj.png";
    private static final String YOUR_EMAIL = "1126834403@qq.com";
    private static final String YOUR_NAME = "DIMPLES";

    private static final String FOOTER_ABOUT = "DIMPLES的博客. have fun.";
    private static final String FOOTER_ICP = "浙ICP备 xxxxxx-x号";
    private static final String FOOTER_COPY_RIGHT = "@2019 dimples";
    private static final String FOOTER_POWERED_BY = "dimples blog";
    private static final String FOOTER_POWERED_BY_URL = "##";

    @Override
    public int updateConfig(String configName, String configValue) {
        BlogConfig blogConfig = configMapper.selectByPrimaryKey(configName);
        if (blogConfig != null) {
            blogConfig.setConfigValue(configValue);
            blogConfig.setUpdateTime(new Date());
            return configMapper.updateByPrimaryKeySelective(blogConfig);
        }
        return 0;
    }

    @Override
    public Map<String, String> getAllConfigs() {
        //获取所有的map并封装为map
        List<BlogConfig> blogConfigs = configMapper.selectAll();

        //将List集合转换为Map
        Map<String, String> configMap = blogConfigs.stream().collect(Collectors.toMap(BlogConfig::getConfigName, BlogConfig::getConfigValue));

        for (Map.Entry<String, String> config : configMap.entrySet()) {
            if ("WEBSITE_NAME".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_NAME);
            }
            if ("WEBSITE_DESCRIPTION".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_DESCRIPTION);
            }
            if ("WEBSITE_LOGO".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_LOGO);
            }
            if ("WEBSITE_ICON".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(WEBSITE_ICON);
            }
            if ("YOUR_AVATAR".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(YOUR_AVATAR);
            }
            if ("YOUR_EMAIL".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(YOUR_EMAIL);
            }
            if ("YOUR_NAME".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(YOUR_NAME);
            }
            if ("FOOTER_ABOUT".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_ABOUT);
            }
            if ("FOOTER_ICP".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_ICP);
            }
            if ("FOOTER_COPY_RIGHT".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_COPY_RIGHT);
            }
            if ("FOOTER_POWERED_BY".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_POWERED_BY);
            }
            if ("FOOTER_POWERED_BY_URL".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(FOOTER_POWERED_BY_URL);
            }
        }
        return configMap;
    }
}
