package com.yh.exception;

import com.yh.util.Result;
import com.yh.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 * Created by HR on 2018/5/9.
 */
@RestControllerAdvice
public class ExceptionHandle {

//    /**
//     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
//     * @param binder
//     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {}

//    /**
//     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
//     * @param model

    //全局获取
//    @RequestMapping("/home")
//    public String home(ModelMap modelMap) {
//        System.out.println(modelMap.get("author"));
//    }
//
////或者 通过@ModelAttribute获取
//
//    @RequestMapping("/home")
//    public String home(@ModelAttribute("author") String author) {
//        System.out.println(author);
//    }
//     */
//    @ModelAttribute
//    public void addAttributes(Model model) {
//        model.addAttribute("author", "yh");
//    }

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = SystemException.class)
    public Result systemException(SystemException systemException){

        logger.error("[自定义异常]{}", systemException);

        return  ResultUtil.error(systemException.getCode(), systemException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){

        logger.error("[系统异常]{}", e);
        return ResultUtil.error(-1, "just error:" + e.getMessage());
    }

    //* 如果不需要返回json数据，而要渲染某个页面模板返回给浏览器
//    @ExceptionHandler(value = SystemException.class)
//    public ModelAndView myErrorHandler(SystemException ex) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("error");
//        modelAndView.addObject("code", ex.getCode());
//        modelAndView.addObject("msg", ex.getMessage());
//        return modelAndView;
//    }

}
