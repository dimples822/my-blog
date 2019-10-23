package com.site.blog.my.core.controller.blog;

import com.site.blog.my.core.config.Constants;
import com.site.blog.my.core.controller.vo.BlogDetailVO;
import com.site.blog.my.core.entity.BlogComment;
import com.site.blog.my.core.entity.BlogLink;
import com.site.blog.my.core.entity.NoteDetail;
import com.site.blog.my.core.entity.NotebookName;
import com.site.blog.my.core.service.BlogService;
import com.site.blog.my.core.service.CategoryService;
import com.site.blog.my.core.service.CommentService;
import com.site.blog.my.core.service.ConfigService;
import com.site.blog.my.core.service.LinkService;
import com.site.blog.my.core.service.NoteDetailService;
import com.site.blog.my.core.service.NoteLabelService;
import com.site.blog.my.core.service.NotebookNameService;
import com.site.blog.my.core.service.TagService;
import com.site.blog.my.core.util.MyBlogUtils;
import com.site.blog.my.core.util.PageResult;
import com.site.blog.my.core.util.PatternUtil;
import com.site.blog.my.core.util.Result;
import com.site.blog.my.core.util.ResultGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 博客显示页面
 *
 * @author zhongyj <1126834403@qq.com><br/>
 * @date 2019/8/21
 */
@Controller
public class MyBlogController {

    public static final String THEME = "amaze";

    private static final int COMMENT_BODY_MAX_LENGTH = 200;

    private static final int LINK_TYPE_FRI = 0;
    private static final int LINK_TYPE_RECOMMEND = 1;
    private static final int LINK_TYPE_PRIVATE = 2;

    private BlogService blogService;
    private TagService tagService;
    private LinkService linkService;
    private CommentService commentService;
    private ConfigService configService;
    private CategoryService categoryService;
    private NotebookNameService notebookNameService;
    private NoteDetailService noteDetailService;
    private NoteLabelService noteLabelService;

    @Autowired
    public MyBlogController(BlogService blogService, TagService tagService, LinkService linkService, CommentService commentService, ConfigService configService, CategoryService categoryService, NotebookNameService notebookNameService, NoteDetailService noteDetailService, NoteLabelService noteLabelService) {
        this.blogService = blogService;
        this.tagService = tagService;
        this.linkService = linkService;
        this.commentService = commentService;
        this.configService = configService;
        this.categoryService = categoryService;
        this.notebookNameService = notebookNameService;
        this.noteDetailService = noteDetailService;
        this.noteLabelService = noteLabelService;
    }

    /**
     * 首页
     *
     * @return String
     */
    @GetMapping({"/", "/index", "index.html"})
    public String index(HttpServletRequest request) {
        return this.page(request, 1);
    }

    /**
     * 首页 分页数据
     *
     * @return String
     */
    @GetMapping({"/page/{pageNum}"})
    public String page(HttpServletRequest request, @PathVariable("pageNum") int pageNum) {
        PageResult blogPageResult = blogService.getBlogsForIndexPage(pageNum);
        if (blogPageResult == null) {
            return "error/error_404";
        }
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("pageName", "首页");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/index";
    }

    /**
     * Categories页面(包括分类数据和标签数据)
     *
     * @return 页面视图
     */
    @GetMapping({"/categories"})
    public String categories(HttpServletRequest request) {
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("categories", categoryService.getAllCategories());
        request.setAttribute("pageName", "分类页面");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/category";
    }

    /**
     * 详情页
     *
     * @return 页面视图
     */
    @GetMapping({"/blog/{blogId}", "/article/{blogId}"})
    public String detail(HttpServletRequest request, @PathVariable("blogId") Long blogId, @RequestParam(value = "commentPage", required = false, defaultValue = "1") Integer commentPage) {
        BlogDetailVO blogDetailVO = blogService.getBlogDetail(blogId);
        if (blogDetailVO != null) {
            request.setAttribute("blogDetailVO", blogDetailVO);
            request.setAttribute("commentPageResult", commentService.getCommentPageByBlogIdAndPageNum(blogId, commentPage));
        }
        request.setAttribute("pageName", "详情");
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/detail";
    }

    /**
     * 标签列表页
     *
     * @return 页面视图
     */
    @GetMapping({"/tag/{tagName}"})
    public String tag(HttpServletRequest request, @PathVariable("tagName") String tagName) {
        return tag(request, tagName, 1);
    }

    /**
     * 标签列表页
     *
     * @return 页面视图
     */
    @GetMapping({"/tag/{tagName}/{page}"})
    public String tag(HttpServletRequest request, @PathVariable("tagName") String tagName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageByTag(tagName, page);
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "标签");
        request.setAttribute("pageUrl", "tag");
        request.setAttribute("keyword", tagName);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/list";
    }

    /**
     * 分类列表页
     *
     * @return 页面视图
     */
    @GetMapping({"/category/{categoryName}"})
    public String category(HttpServletRequest request, @PathVariable("categoryName") String categoryName) {
        return category(request, categoryName, 1);
    }

    /**
     * 分类列表页
     *
     * @return 页面视图
     */
    @GetMapping({"/category/{categoryName}/{page}"})
    public String category(HttpServletRequest request, @PathVariable("categoryName") String categoryName, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageByCategory(categoryName, page);
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "分类");
        request.setAttribute("pageUrl", "category");
        request.setAttribute("keyword", categoryName);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/list";
    }

    /**
     * 搜索列表页
     *
     * @return 页面视图
     */
    @GetMapping({"/search/{keyword}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword) {
        return search(request, keyword, 1);
    }

    /**
     * 搜索列表页
     *
     * @return 页面视图
     */
    @GetMapping({"/search/{keyword}/{page}"})
    public String search(HttpServletRequest request, @PathVariable("keyword") String keyword, @PathVariable("page") Integer page) {
        PageResult blogPageResult = blogService.getBlogsPageBySearch(keyword, page);
        request.setAttribute("blogPageResult", blogPageResult);
        request.setAttribute("pageName", "搜索");
        request.setAttribute("pageUrl", "search");
        request.setAttribute("keyword", keyword);
        request.setAttribute("newBlogs", blogService.getBlogListForIndexPage(1));
        request.setAttribute("hotBlogs", blogService.getBlogListForIndexPage(0));
        request.setAttribute("hotTags", tagService.getBlogTagCountForIndex());
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/list";
    }


    /**
     * 友情链接页
     *
     * @return 页面视图
     */
    @GetMapping({"/link"})
    public String link(HttpServletRequest request) {
        request.setAttribute("pageName", "友情链接");
        Map<Byte, List<BlogLink>> linkMap = linkService.getLinksForLinkPage();
        if (linkMap != null) {
            //判断友链类别并封装数据 0-友链 1-推荐 2-个人网站
            if (linkMap.containsKey((byte) LINK_TYPE_FRI)) {
                request.setAttribute("favoriteLinks", linkMap.get((byte) 0));
            }
            if (linkMap.containsKey((byte) LINK_TYPE_RECOMMEND)) {
                request.setAttribute("recommendLinks", linkMap.get((byte) 1));
            }
            if (linkMap.containsKey((byte) LINK_TYPE_PRIVATE)) {
                request.setAttribute("personalLinks", linkMap.get((byte) 2));
            }
        }
        request.setAttribute("configurations", configService.getAllConfigs());
        return "blog/" + THEME + "/link";
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/blog/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long blogId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String email,
                          @RequestParam String websiteUrl, @RequestParam String commentBody) {
        if (StringUtils.isEmpty(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!verifyCode.equals(kaptchaCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (StringUtils.isEmpty(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == blogId || blogId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (StringUtils.isEmpty(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (StringUtils.isEmpty(email)) {
            return ResultGenerator.genFailResult("请输入邮箱地址");
        }
        if (!PatternUtil.isEmail(email)) {
            return ResultGenerator.genFailResult("请输入正确的邮箱地址");
        }
        if (StringUtils.isEmpty(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > COMMENT_BODY_MAX_LENGTH) {
            return ResultGenerator.genFailResult("评论内容过长");
        }
        BlogComment comment = new BlogComment();
        comment.setBlogId(blogId);
        comment.setCommentator(MyBlogUtils.cleanString(commentator));
        comment.setEmail(email);
        if (PatternUtil.isUrl(websiteUrl)) {
            comment.setWebsiteUrl(websiteUrl);
        }
        comment.setCommentBody(MyBlogUtils.cleanString(commentBody));
        return ResultGenerator.genSuccessResult(commentService.addComment(comment));
    }

    /**
     * 关于页面 以及其他配置了subUrl的文章页
     *
     * @return 页面视图
     */
    @GetMapping({"/{subUrl}"})
    public String detail(HttpServletRequest request, @PathVariable("subUrl") String subUrl) {
        BlogDetailVO blogDetailVO = blogService.getBlogDetailBySubUrl(subUrl);
        if (blogDetailVO != null) {
            request.setAttribute("blogDetailVO", blogDetailVO);
            request.setAttribute("pageName", subUrl);
            request.setAttribute("configurations", configService.getAllConfigs());
            return "blog/" + THEME + "/detail";
        } else {
            return "error/error_400";
        }
    }

    /**
     * 个人笔记
     *
     * @return ModelAndView
     */
    @GetMapping("/notes")
    public ModelAndView getNotes() {
        ModelAndView view = new ModelAndView();
        view.setViewName("notes/note-index");
        List<NotebookName> notebookName = notebookNameService.selectAll();
        NoteDetail noteDetail = noteDetailService.selectByPrimaryKey(1L);
        view.addObject("notebookName", notebookName);
        view.addObject("noteDetail", noteDetail);
        return view;
    }

    /**
     * 根据id获取笔记
     *
     * @param id Long
     * @return NoteDetail
     */
    @GetMapping("/notes/{id}")
    @ResponseBody
    public NoteDetail getNotesDetailById(@PathVariable() Long id) {
        return noteDetailService.selectByPrimaryKey(id);
    }

    /**
     * 插入笔记本名称
     *
     * @param notebookName NotebookName
     * @return Result
     */
    @PostMapping("/notes/notebook")
    public Result saveNotebookName(NotebookName notebookName) {
        int result = notebookNameService.insertSelective(notebookName);
        return result > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("数据插入失败");
    }

    /**
     * 获取所有笔记本
     *
     * @return Result
     */
    @GetMapping("/notes/notebook")
    @ResponseBody
    public Result getNotebookName() {
        List<NotebookName> notebookName = notebookNameService.selectAll();
        return notebookName != null ? ResultGenerator.genSuccessResult(notebookName) : ResultGenerator.genSuccessResult(ResultGenerator.DEFAULT_SUCCESS_MESSAGE_NOT_FIND);
    }

    /**
     * 笔记编辑
     *
     * @return ModelAndView
     */
    @GetMapping({"/notes/edit/{id}"})
    public ModelAndView notesEdit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView();
        List<NotebookName> notebookName = notebookNameService.selectAll();
        List<String> labelName = new ArrayList<>(3);
        labelName.addAll(Arrays.asList(Constants.LABEL_LIST));
        NoteDetail noteDetail = noteDetailService.selectByPrimaryKey(id);
        view.addObject("notebookName", notebookName);
        view.addObject("labelName", labelName);
        view.addObject("noteDetail", noteDetail);
        view.addObject("pageType", "edit");
        view.setViewName("notes/note-edit");
        return view;
    }

    @GetMapping("/notes/add")
    public ModelAndView notesAdd() {
        ModelAndView view = new ModelAndView();
        view.setViewName("notes/note-edit");
        return view;
    }

}
















