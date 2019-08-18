package com.site.blog.my.core.service.impl;

import com.site.blog.my.core.mapper.BlogConfigMapper;
import com.site.blog.my.core.entity.BlogConfig;
import com.site.blog.my.core.service.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private BlogConfigMapper configMapper;

    public static final String WEBSITE_NAME = "DIMPLES BLOG";
    public static final String WEBSITE_DESCRIPTION = "个人学习与工作的总结";
    public static final String websiteLogo = "/admin/dist/img/logo2.png";
    public static final String websiteIcon = "/admin/dist/img/favicon.png";

    public static final String yourAvatar = "/admin/dist/img/13.png";
    public static final String yourEmail = "1126834403@qq.com";
    public static final String yourName = "DIMPLES";

    public static final String footerAbout = "DIMPLES的博客. have fun.";
    public static final String footerICP = "浙ICP备 xxxxxx-x号";
    public static final String footerCopyRight = "@2019 dimples";
    public static final String footerPoweredBy = "dimples blog";
    public static final String footerPoweredByURL = "##";

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
            if ("websiteLogo".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(websiteLogo);
            }
            if ("websiteIcon".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(websiteIcon);
            }
            if ("yourAvatar".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(yourAvatar);
            }
            if ("yourEmail".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(yourEmail);
            }
            if ("yourName".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(yourName);
            }
            if ("footerAbout".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(footerAbout);
            }
            if ("footerICP".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(footerICP);
            }
            if ("footerCopyRight".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(footerCopyRight);
            }
            if ("footerPoweredBy".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(footerPoweredBy);
            }
            if ("footerPoweredByURL".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
                config.setValue(footerPoweredByURL);
            }
        }
        return configMap;
    }
}
