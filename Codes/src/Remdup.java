
public class Remdup {
    
    private Node first;
    private Node next;
    
    public Remdup()
    {
        first = null;
    }
    
    //add students to the list
    public void add(String s)
    {
        Node newNode = new Node(s);
        newNode.next = first;
        first = newNode;        
    }
    
    //remove duplicate records (return true if duplicate found)
    public boolean remove(String fn, String ln)
    {
    	String remove;
        boolean found = false;
        int duplicate = 0;
        
        for(Node iterator = first; iterator != null; iterator = iterator.next)
        {
            if(first.value.getFname().equals(fn) && first.value.getLname().equals(ln))
            {
                duplicate++;
                if(duplicate > 1)
                {
                    remove = first.value;
                    first = first.next;
                    return found = true;  
                    
                }                
            }
        }
        return found;
    }
      
    //display list of student
    public void display()
    {
        if(first == null)
            System.out.println("List is empty!");
        else
        {
            while(first != null)
            {
                System.out.println(first.value);
                first = first.next;
            }            
        }            
    }
    
}

public class Tester {
    
    public static void main(String[] args) {
        
    	/*
        UnderGrad john = new UnderGrad("john", "doe", 2.7, "computer Science", "phisics");
        UnderGrad jorge = new UnderGrad("jorge", "vazquez", 3.8, "computer Science", "programming");
        UnderGrad john2 = new UnderGrad("john", "doe", 3.0, "Computer Engineering", "phisics");
        
        Advisor jim = new Advisor("jim", "smith");
        
        Grad jane = new Grad("jane", "mckee", 3.0, "Electric Engineering", jim);       
         */      
              
    	Remdup students = new Remdup();
        
        students.add("john");
        students.add("jorge");
        students.add("jorge");
        students.add("john2");
        students.add("jane");
        
    
        System.out.println(students.remove("john", "doe"));
        
        students.display();  
        
    }
}