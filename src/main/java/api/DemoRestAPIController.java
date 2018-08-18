package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.DemoObject;
import repo.DemoObjectRepo;

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
        return null;
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

}
