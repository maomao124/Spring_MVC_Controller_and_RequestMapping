package mao.spring_mvc_controller_and_requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Project name(项目名称)：Spring_MVC_Controller_and_RequestMapping
 * Package(包名): mao.spring_mvc_controller_and_requestmapping
 * Class(类名): IndexController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/6
 * Time(创建时间)： 20:00
 * Version(版本): 1.0
 * Description(描述)：
 * 1. value 属性
 * value 属性是 @RequestMapping 注解的默认属性，因此如果只有 value 属性时，可以省略该属性名，如果有其它属性，则必须写上 value 属性名称。如下。
 * /@RequestMapping(value="toUser")
 * /@RequestMapping("toUser")
 * value 属性支持通配符匹配，如 @RequestMapping(value="toUser/*") 表示 http://localhost:8080/toUser/1 或 http://localhost:8080/toUser/hahaha 都能够正常访问。
 * 2. path属性
 * path 属性和 value 属性都用来作为映射使用。即 @RequestMapping(value="toUser") 和 @RequestMapping(path="toUser") 都能访问 toUser() 方法。
 * <p>
 * path 属性支持通配符匹配，如 @RequestMapping(path="toUser/*") 表示 http://localhost:8080/toUser/1 或 http://localhost:8080/toUser/hahaha 都能够正常访问。
 * 3. name属性
 * name属性相当于方法的注释，使方法更易理解。如 @RequestMapping(value = "toUser",name = "获取用户信息")。
 * 4. method属性
 * method 属性用于表示该方法支持哪些 HTTP 请求。如果省略 method 属性，则说明该方法支持全部的 HTTP 请求。
 * <p>
 * /@RequestMapping(value = "toUser",method = RequestMethod.GET) 表示该方法只支持 GET 请求。也可指定多个 HTTP 请求，
 * 如 @RequestMapping(value = "toUser",method = {RequestMethod.GET,RequestMethod.POST})，说明该方法同时支持 GET 和 POST 请求。
 * 5. params属性
 * params 属性用于指定请求中规定的参数
 * 6. header属性
 * header 属性表示请求中必须包含某些指定的 header 值。
 * <p>
 * /@RequestMapping(value = "toUser",headers = "Referer=http://www.xxx.com") 表示请求的 header 中必须包含了指定的“Referer”请求头，以及值为“http://www.xxx.com”时，才能执行该请求。
 * 7. consumers属性
 * consumers 属性用于指定处理请求的提交内容类型（Content-Type），例如：application/json、text/html。如
 * /@RequestMapping(value = "toUser",consumes = "application/json")。
 * 8. produces属性
 * produces 属性用于指定返回的内容类型，返回的内容类型必须是 request 请求头（Accept）中所包含的类型。如 @RequestMapping(value = "toUser",produces = "application/json")。
 * <p>
 * 除此之外，produces 属性还可以指定返回值的编码。如 @RequestMapping(value = "toUser",produces = "application/json,charset=utf-8")，表示返回 utf-8 编码。
 * <p>
 * 使用 @RequestMapping 来完成映射，具体包括 4 个方面的信息项：请求 URL、请求参数、请求方法和请求头。
 */

@Controller
public class IndexController
{
    @RequestMapping(value = "test", method = RequestMethod.GET, params = {"one", "two"})
    @ResponseBody
    public String test()
    {
        return "hello";
    }

    @RequestMapping(value = "test2")
    @ResponseBody
    public String test2(@RequestParam(required = false) String username)
    {
        System.out.println(username);
        return "hello";
    }

    @RequestMapping(value = "test3")
    @ResponseBody
    public String test3(HttpSession session, HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println(session);
        System.out.println(request);
        System.out.println(response);
        return "hello";
    }

    @RequestMapping("/login")
    public String getLogin(Model model)
    {
        model.addAttribute("user", "12345");
        return "login";
    }

    @RequestMapping("/register")
    public String getRegister()
    {
        return "register";
    }

}
