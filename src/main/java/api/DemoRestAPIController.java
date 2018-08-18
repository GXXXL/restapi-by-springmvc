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
@RequestMapping("/demoobjects")
public class DemoRestAPIController {

    @Autowired
    private DemoObjectRepo repo;

    @RequestMapping(method = RequestMethod.GET)
    public List<DemoObject> queryByPagination(@RequestParam int offset, @RequestParam int limit) {
        return repo.getList().subList(offset, offset + limit);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public DemoObject queryById(@PathVariable long id) {
        for (DemoObject dobj : repo.getList()) {
            if (id == dobj.getId()) {
                return dobj;
            }
        }
        throw new DemoObjectNotFoundException(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/count")
    public int count() {
        return repo.getList().size();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public long create(@RequestBody DemoObject newObj) {
        long id = 76241L;   //generate id for the new object. i simplify the strategy for simplicity.
        newObj.setId(id);
        repo.getList().add(newObj);
        return id;
    }

    @ExceptionHandler(DemoObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error demoObjectNotFound(DemoObjectNotFoundException e) {
        long demoObjectId = e.getDemoObjectId();
        return new Error(13, MessageFormat.format("DemoObject {0} not found.", demoObjectId));
    }

}
