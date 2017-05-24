package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RuleTypeEnum {

    BASIC(1, "基础规则"),
    DEDUCTION(2, "减免规则"),
    MARKET(3,"营销规则");

    private int key;
    private String value;

    RuleTypeEnum(int key, String value) {
            this.key = key;
            this.value = value;
    }

    public static String getValue(int key) {
            for (RuleTypeEnum ft : RuleTypeEnum.values()) {
                    if (ft.getKey() == key) {
                            return ft.getValue();
                    }
            }
            return null;
    }

    public int getKey() {
            return key;
    }

    public void setKey(int key) {
            this.key = key;
    }

    public String getValue() {
            return value;
    }

    public void setValue(String value) {
            this.value = value;
    }

    public static List<RuleTypeEnum> Java8RuleTypeEnumToList(){
            return Stream.of(RuleTypeEnum.values()).collect(Collectors.toList());
    }
    public static List<RuleTypeEnum> RuleTypeEnumToList(){
        List<RuleTypeEnum> list = new ArrayList<RuleTypeEnum>();
        for (RuleTypeEnum ruleTypeEnum : RuleTypeEnum.values())
        {
                list.add(ruleTypeEnum);
        }
        return list;
}

}
