package dmall_cms;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Business {

    //门店管理中维护的ID
    O2O(1,"多点超市"),
    //门店管理中维护的ID
    GLOBAL(2,"全球精选"),
    //门店管理中维护的ID
    OVERSEAS(3,"海淘"),
    //门店管理中维护的ID
    WAIMAI(5,"外卖"),
    //门店管理中维护的ID
    NEXT_DAY(6,"半日达");
    
    private int id;
    private String name;
    Business(int id, String name){
        this.id = id;
        this.name = name;
    }
    public Map<Integer,String> toMap(){
        return Stream.of(Business.values())
                    .collect(Collectors
                            .toMap(b -> b.id, b -> b.name));
    }
    
    public static void main(String[] args) {
        System.out.println(Business.O2O.toMap());
    }
}
