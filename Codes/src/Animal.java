import java.security.KeyStore.Entry;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/* Link list node */
class node
{
    int data;
     node next;
}
 
/* pull off the front node of the source and put it in dest */
void MoveNode(struct node** destRef, struct node** sourceRef);
 
/* Takes two lists sorted in increasing order, and splices their nodes together to make one big sorted list which is returned.  */
node SortedMerge( node a, node b) 
{
   /* a dummy first node to hang the result on */   
   node dummy;      
    
   /* tail points to the last result node  */
   node tail = dummy;  
 
   /* so tail->next is the place to add new nodes 
     to the result. */
   dummy.next = null;
   while(true) 
   {
      if(a == null) 
      { 
         /* if either list runs out, use the other list */
         tail.next = b;
         break;
      }
      else if (b == null) 
      {
         tail.next = a;
         break;
      }
      if (a.data <= b.data) 
      {
         MoveNode((tail.next), a);
      }
      else
     {
        MoveNode((tail.next), b);
     }
     tail = tail.next;
  }
  return(dummy.next);
}  
 
 
/* UTILITY FUNCTIONS */
/*MoveNode() function takes the node from the front of the source, and move it to the front of the dest.
   It is an error to call this with the source list empty. 
 
   Before calling MoveNode():
   source == {1, 2, 3}
   dest == {1, 2, 3}
 
   Affter calling MoveNode():
   source == {2, 3}
   dest == {1, 1, 2, 3}
*/
void MoveNode( node destRef,  node sourceRef)
{
  /* the front source node  */
   node newNode = sourceRef;
  assert(newNode != null);
 
  /* Advance the source pointer */
  sourceRef = newNode.next;
 
  /* Link the old dest off the new node */
  newNode.next = destRef; 
 
  /* Move dest to point to the new node */
  destRef = newNode;
}
 
 
/* Function to insert a node at the beginging of the linked list */
void push(struct node** head_ref, int new_data)
{
  /* allocate node */
  struct node* new_node =
            (struct node*) malloc(sizeof(struct node));
 
  /* put in the data  */
  new_node->data  = new_data;
 
  /* link the old list off the new node */
  new_node->next = (*head_ref);     
 
  /* move the head to point to the new node */
  (*head_ref)    = new_node;
}
 
/* Function to print nodes in a given linked list */
void printList(struct node *node)
{
  while(node!=NULL)
  {
   printf("%d ", node->data);
   node = node->next;
  }
} 
 
/* Drier program to test above functions*/
int main()
{
  /* Start with the empty list */
  struct node* res = NULL;
  struct node* a = NULL;
  struct node* b = NULL;  
 
  /* Let us create two sorted linked lists to test the functions
   Created lists shall be a: 5->10->15,  b: 2->3->20 */
  push(&a, 15);
  push(&a, 10);
  push(&a, 5);
   
  push(&b, 20);
  push(&b, 3);
  push(&b, 2);  
 
  /* Remove duplicates from linked list */
  res = SortedMerge(a, b); 
 
  printf("\n Merged Linked List is: \n");
  printList(res);            
 
  getchar();
  return 0;
}

class TestResult {
    int studentId;
    String testDate;
    int testScore;
 }
class aaa
{
	Map<Integer, Double>  calculateFinalScores (List<TestResult> results) {
    // create priority queue of final results to be returned
    Map<Integer, Double> final_results;
    // temporary map of priority_queue keys for each test result
    Map<Integer, PriorityQueue<TestResult>> scores;
    
    Iterator it = results.iterator() ;
    while(it.hasNext())
    {
    	TestResult tr = (TestResult) it.next();
    	
    	PriorityQueue<TestResult> testresultQueu = new PriorityQueue<TestResult>();
    	if (scores.containsKey(tr.studentId)) 
    	{
    		testresultQueu = scores.get(tr.studentId);
    	}
    	testresultQueu.add(tr);
        scores.put(tr.studentId, testresultQueu);
    }
    
    // initialize map values
  //  for(map<int,int>::iterator it=scores.begin(); it!=scores.end(); it++) {
   //    final_results[it->first] = 0; 
   // }
    
    // divide the sums to get the average of the top 5 or less scores
   
    
    for(java.util.Map.Entry<Integer, PriorityQueue<TestResult>> e : scores.entrySet())
    {
    	double total =0;
    
    	for(int i=0;i<5;i++){
    		if(!e.getValue().isEmpty()){
    			total = total + (e.getValue().poll()).testScore; 
    		}
    	}
    	final_results.put(e.getKey(),total/5);
    	
    }
    
    for(map<int,int>::iterator it=scores.begin(); it!=scores.end(); it++) {
        for(int i = 0; i < 5; i++)
            if(!(it->second).empty())
                final_results[it->first] += (it->second).pop();
        if((it->second).size() >= 5)
            final_results[it->first] = (float)(final_results[it->first] / 5);
        else
            final_results[it->first] = (float)(final_results[it->first] / ((it->second).size()));
    }
    return final_results;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
