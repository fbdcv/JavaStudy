package commonclass;

public class Test05 {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Integer ints[] =  new Integer[1000];
        long before = runtime.freeMemory();
        for(Integer i:ints){
            i=10000;//i赋的值不能-128~127的数，否则因为常量池机制监测不到变化
        }
        long after = runtime.freeMemory();
        System.out.println("赋值前的空闲内存字节数："+before);
        System.out.println("赋值后的空闲内存字节数："+after);
        System.out.println("赋值消耗内存字节数："+(before-after));
    }
}
