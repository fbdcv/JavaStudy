package Test;

enum SeasonEnum{
    Spring("春天来了"),
    Summer("夏天来了"),
    Autumn("秋天来了"),
    Winter("冬天来了");

    private String remarks;
    private SeasonEnum(String remarks){
        this.remarks=this.toString()+":"+remarks;
    }

    public String getRemarks() {
        return remarks;
    }
}

public class Enum2 {
    public static void main(String[] args) {
        SeasonEnum[] seasonEnums = SeasonEnum.values();
        for(SeasonEnum s:seasonEnums){
            System.out.println(s.getRemarks());
        }
    }
}
