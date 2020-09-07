class LRUCache {

    DoublyLinkedList back,head;
    int currentCapacity,maxCapacity;
    HashMap<Integer,DoublyLinkedList> hashMap;
    public LRUCache(int capacity) {
        head=null;
        back=null;
        hashMap = new HashMap<>();
        currentCapacity=0;
        maxCapacity=capacity;
    }

    public int get(int key) {
        int ans=-1;
        if(hashMap.getOrDefault(key,null)!=null)
        {
            DoublyLinkedList node = hashMap.get(key);
            ans=(int)hashMap.get(key).value;
            if(hashMap.get(key)!=head) {
                DoublyLinkedList tmp = new DoublyLinkedList(node.key, node.value);
                addNode(tmp);
                hashMap.remove(node.key);
                hashMap.put(tmp.key,tmp);
                removeNode(node);
            }
        }
        //System.out.println(ans);
        return ans;
    }

    public void put(int key, int value) {
        DoublyLinkedList node = new DoublyLinkedList(key,value);
        if(hashMap.getOrDefault(key,null)!=null){
            addNode(node);
            removeNode(hashMap.get(key));
            hashMap.remove(hashMap.get(key).key);
            hashMap.put(key,node);
        }
        else
        {
            currentCapacity++;
            if(currentCapacity > maxCapacity)
            {
                currentCapacity--;
                hashMap.remove(back.key);
                removeLastNode();
            }
            hashMap.put(key,node);
            if(head==null){
                head=node;
                back=node;
            }
            else
            {
                addNode(node);
            }
        }
    }
    void removeNode(DoublyLinkedList node)
    {
        if(node==back)
        {
            back=back.left;
            back.right=null;
        }
        else
        {
            DoublyLinkedList tmp=node;
            node.left.right=tmp.right;
            node.right.left=tmp.left;
            tmp=null;
        }
    }
    void removeLastNode()
    {
        if(maxCapacity == 1) {
            head = null;
            back = null;
        }
        else
        {
            back=back.left;
            back.right=null;
        }
    }
    void addNode(DoublyLinkedList node)
    {
        head.left=node;
        node.right=head;
        head=node;
    }
}
class DoublyLinkedList{
    int key,value;
    DoublyLinkedList left,right;

    public DoublyLinkedList(int key, int value) {
        this.key=key;
        this.value=value;
        left=null;
        right=null;
    }
}
