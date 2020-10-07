import jdk.internal.jimage.ImageReader.Node;

public class SinglyList<T> extends Object {
    public Node<T> head;

    public SinglyList(){
        this.head = new Node<T>();
    }

    public SinglyList(T[] values){
        this();
        Node<T> rear = this.head;
        for(int i = 0; i<values.length; i++){
            if(values[i]!=null){
                rear.next = new Node<T>(values[i], null);
                rear = rear.next;
            }
        }
    }

    public boolean isEmpty(){
        return this.head.next==null;
    }

    public T get(int i){
        Node<T> p = this.head.next;
        for(int j =0; p!=null && j<i; j++){
            p = p.next;
        }
        return (i>=0 && p!=null) ? p.data : null;
    }

    public void set(int i, T x){

    }

    public int size(){

    }

    public String toString(){
        String str = this.getClass().getName()+"(";
        for(Node<T> p=this.head.next; p!=null; p=p.next){
            str += p.data.toString() + (p.next!=null?",":"");
        }
        return str;
    }

    public Node<T> insert(int i, T x){
        if(x==null)
            return null;
        Node<T> front = this.head;
        for(int j=0; front.next!=null && j<i; j++)
            front = front.next;
        front.next = new Node<T>(x, front.next);
        return front.next;
    }

    public Node<T> insert(T x){
        return insert(Intefer.Max_VALUE, x);
    }

    public T remove(int i){
        Node<T> front = this.head;
        for(int j=0; front.next!=null && j<i; j++)
            front = front.next;
        if(i>=0 && front.next!=null){
            T x = front.next.data;
            front.next = front.next.next;
            return x;
        }
        return null;
    }

    public void clear(){
        this.head.next = null;
    }

    public Node<T> search(T key){

    }

    public T remove(T key){

    }

    public static void main(String[] args) {
        String []values = {"A", "B", "C", "D", "E", "F"};
        SinglyList<String> lista = new SinglyList<String>(values);
        
        Node<String> head = lista.head;
        while(head.next!=null){
            System.out.println(head.next.toString());
            head = head.next;
        }
    }
}
