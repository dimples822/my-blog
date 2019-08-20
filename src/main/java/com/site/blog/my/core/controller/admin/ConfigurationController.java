package com.site.blog.my.core.controller.admin;

import com.site.blog.my.core.service.ConfigService;
import com.site.blog.my.core.util.Result;
import com.site.blog.my.core.util.ResultGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhongyj
 * @date 2019/8/11
 */
@Controller
@RequestMapping("/admin")
public class ConfigurationController {

    @Resource
    private ConfigService configService;

    @GetMapping("/configurations")
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "configurations");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "admin/configuration";
    }

    @PostMapping("/configurations/website")
    @ResponseBody
    public Result website(@RequestParam(value = "WEBSITE_NAME", required = false) String websiteName,
                          @RequestParam(value = "WEBSITE_DESCRIPTION", required = false) String websiteDescription,
                          @RequestParam(value = "WEBSITE_LOGO", required = false) String websiteLogo,
                          @RequestParam(value = "WEBSITE_ICON", required = false) String websiteIcon) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(websiteName)) {
            updateResult += configService.updateConfig("WEBSITE_NAME", websiteName);
        }
        if (!StringUtils.isEmpty(websiteDescription)) {
            updateResult += configService.updateConfig("WEBSITE_DESCRIPTION", websiteDescription);
        }
        if (!StringUtils.isEmpty(websiteLogo)) {
            updateResult += configService.updateConfig("WEBSITE_LOGO", websiteLogo);
        }
        if (!StringUtils.isEmpty(websiteIcon)) {
            updateResult += configService.updateConfig("WEBSITE_ICON", websiteIcon);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }

    @PostMapping("/configurations/userInfo")
    @ResponseBody
    public Result userInfo(@RequestParam(value = "YOUR_AVATAR", required = false) String yourAvatar,
                           @RequestParam(value = "YOUR_NAME", required = false) String yourName,
                           @RequestParam(value = "YOUR_EMAIL", required = false) String yourEmail) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(yourAvatar)) {
            updateResult += configService.updateConfig("YOUR_AVATAR", yourAvatar);
        }
        if (!StringUtils.isEmpty(yourName)) {
            updateResult += configService.updateConfig("YOUR_NAME", yourName);
        }
        if (!StringUtils.isEmpty(yourEmail)) {
            updateResult += configService.updateConfig("YOUR_EMAIL", yourEmail);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }

    @PostMapping("/configurations/footer")
    @ResponseBody
    public Result footer(@RequestParam(value = "FOOTER_ABOUT", required = false) String footerAbout,
                         @RequestParam(value = "FOOTER_ICP", required = false) String footerIcp,
                         @RequestParam(value = "FOOTER_COPY_RIGHT", required = false) String footerCopyRight,
                         @RequestParam(value = "FOOTER_POWERED_BY", required = false) String footerPoweredBy,
                         @RequestParam(value = "FOOTER_POWERED_BY_URL", required = false) String footerPoweredByUrl) {
        int updateResult = 0;
        if (!StringUtils.isEmpty(footerAbout)) {
            updateResult += configService.updateConfig("FOOTER_ABOUT", footerAbout);
        }
        if (!StringUtils.isEmpty(footerIcp)) {
            updateResult += configService.updateConfig("FOOTER_ICP", footerIcp);
        }
        if (!StringUtils.isEmpty(footerCopyRight)) {
            updateResult += configService.updateConfig("FOOTER_COPY_RIGHT", footerCopyRight);
        }
        if (!StringUtils.isEmpty(footerPoweredBy)) {
            updateResult += configService.updateConfig("FOOTER_POWERED_BY", footerPoweredBy);
        }
        if (!StringUtils.isEmpty(footerPoweredByUrl)) {
            updateResult += configService.updateConfig("FOOTER_POWERED_BY_URL", footerPoweredByUrl);
        }
        return ResultGenerator.genSuccessResult(updateResult > 0);
    }


}
