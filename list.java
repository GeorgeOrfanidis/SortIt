
import java.util.*;
 
/*  Class Node  */
class Node
{
    protected String data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        data = "";
    }    
    /*  Constructor  */
    public Node(String d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(String d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public String getData()
    {
        return data;
    }
}
 

public class list
{
    private Node front, rear;
    public int size;
 
    /* Constructor */
    public list()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    /*  Function to check if queue is empty */
    public boolean isEmpty()
    {
        return front == null;
    }    
    public int returnSize()
    {
        return size; 
    }
    /*  Function to insert an element to the queue */
    public void insert(String data)
    {
        Node nptr = new Node(data, null);
        if (rear == null)
        {
            front = nptr;
            rear = nptr;
        }
        else
        {
            rear.setLink(nptr);
            rear = rear.getLink();
        }
        size++ ;
    }    
    /*  Function to remove front element from the queue */
    public void  pop()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        Node ptr = front;
        front = ptr.getLink();        
        if (front == null)
            rear = null;
        size-- ;        
        //return ptr.getData();
    }    
    /*  Function to check the front element of the queue */
    public String top()
    {
        if (isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
        return front.getData();
    }    
    void print()
    {
        while (front!=null){
         System.out.println(front.getData()+" ");
         front=front.link; 
       }
    }
}