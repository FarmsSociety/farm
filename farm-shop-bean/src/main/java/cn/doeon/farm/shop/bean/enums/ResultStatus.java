package cn.doeon.farm.shop.bean.enums;

public enum  ResultStatus {

    SUCCESS(0),  // 成功
    FAIL(1);     // 失败

    private Integer num;

    public Integer value() {
        return num;
    }

    ResultStatus(Integer num){
        this.num = num;
    }
}
