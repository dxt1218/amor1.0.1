package dxt.wj.customer.models.dto;

import dxt.wj.customer.models.po.CustomerBasic;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class ParamList {
    private List<CustomerBasic> list;
    private Map map;

    public ParamList(List<CustomerBasic> list, Map map) {
        this.list = list;
        this.map = map;
    }
}
