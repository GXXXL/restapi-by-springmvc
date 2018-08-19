package api;

import exception.DemoObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pojo.DemoObject;
import repo.DemoObjectRepo;

import java.text.MessageFormat;
import java.util.List;

@RestController
/*
 * @RestController注解包含了@Controller注解和@ResponseBody注解。
 * @Controller注解表示这个类是一个SpringMVC控制器。
 * 正常情况下，控制器的处理器方法返回String时，会被SpringMVC理解为要渲染的视图名称，然后DispatcherServlet会调用视图解析器将逻辑视图名解析为实际的视图；返回对象时，会被放到模型中。
 * @ResponseBody注解告诉Spring跳过这两个过程，使用消息转换器来处理方法返回。
 * DispatcherServlet会根据请求中的Accept头部信息，查找能够为客户端提供所需的表述形式的消息转换器。
 */
@RequestMapping("/demoobjects")
//请求映射，类级别的@RequestMapping会应用到该控制器的所有处理器方法上。处理器方法上的@RequestMapping是对类级别的@RequestMapping的声明的补充。
public class DemoRestAPIController {

    @Autowired
    private DemoObjectRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    /*
     * @RequestParam获取URL参数。
     */
    public List<DemoObject> queryByPagination(@RequestParam int offset, @RequestParam int limit) {
        return repo.getDemoObjects().subList(offset, offset + limit);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    /*
     * @PathVariable获取URL路径里的参数。
     */
    public DemoObject queryById(@PathVariable long id) {
        for (DemoObject dobj : repo.getDemoObjects()) {
            if (id == dobj.getId()) {
                return dobj;
            }
        }
        throw new DemoObjectNotFoundException(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/count")
    public int count() {
        return repo.getDemoObjects().size();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public long create(@RequestBody DemoObject newObj) {
        long id = 76241L;   //generate id for the new object. i simplify the strategy for simplicity.
        newObj.setId(id);
        repo.getDemoObjects().add(newObj);
        return id;
    }

    @ExceptionHandler(DemoObjectNotFoundException.class) //@ExceptionHandler注解作用的方法用来处理指定的异常。
    @ResponseStatus(HttpStatus.NOT_FOUND)  //@ResponseStatus注解可以指定响应的状态码。
    public Error demoObjectNotFound(DemoObjectNotFoundException e) {
        long demoObjectId = e.getDemoObjectId();
        return new Error(13, MessageFormat.format("DemoObject {0} not found.", demoObjectId));
    }

}
