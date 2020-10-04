public class Josephus {
    //n个人，n>0；从start开始计数， 0<=start<n；每次数到distance的人出环，0<distance<n
    public Josephus(int n, int start, int distance){
        if(n <= 0 || start < 0 || start >= n || distance <=0 || distance >= n)
            throw new IllegalArgumentException("n=" +n+ ",start=" +start+ ",distance=" + distance);
        System.out.print("Josephus("+n+","+start+","+distance+"),");

        //创建顺序表实例，元素类型是在字符串，构造方法参数指定顺序表的容量，省略时取默认值
        SeqList<String> list = new SeqList<String>(n);

        for(int i = 0; i <n; i++)
            list.insert((char)('A'+i)+" ");
        System.out.println(list.toString());
        while(n>1){
            start = (start + distance -1) % n;
            //输出删除的start位置对象和顺序表中剩余元素，两者均为O(n)
            System.out.println("删除" + list.remove(start).toString() + ", " + list.toString());
            n--;
        }
        System.out.println("被赦免者是：" + list.get(0).toString());
    }

    public static void main(String[] args) {
        new Josephus(6, 1, 3);
    }
}
