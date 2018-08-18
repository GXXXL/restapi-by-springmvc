package repo;

import org.springframework.stereotype.Component;
import pojo.DemoObject;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoObjectRepo {

    private List<DemoObject> list = new ArrayList<DemoObject>() {
        {
            add(new DemoObject(63179, "房屋漏水", "阅城国际房屋漏水。"));
            add(new DemoObject(51742, "电梯故障", "景明佳园电梯故障。"));
            add(new DemoObject(12764, "汽车故障", "比亚迪汽车故障。"));
            add(new DemoObject(37876, "空调维修", "托乐嘉5B507室空调需要维修。"));
            add(new DemoObject(29131, "房屋漏水", "凤翔新城房屋漏水。"));
            add(new DemoObject(40333, "电梯故障", "南京研究所N2电梯故障。"));
        }
    };

    public List<DemoObject> getList() {
        return list;
    }

}
