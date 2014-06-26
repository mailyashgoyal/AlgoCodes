import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        LinkedList list = new LinkedList(); // declaring main linked list
        LinkedList b_List = new LinkedList(); // declaring the backup list

        String input = null;
        // getting input from user, will stop when user has entered 'fin'
        while(!(input = br.readLine()).equals("fin")) {
            list.add(input); // adding to main list
            b_List.add(input);
        }

        list.print(list.getHead().getNext());

        System.out.println("Input Complete.");
        if(list.size() == 1) {
            System.out.println("You have entered only one name. He/She is the survior");
        }else {
            System.out.println("Enter the name(s) would like to remove: ");
            while(b_List.size() != 1) {
                String toRemove = br.readLine();
                b_List.remove(toRemove);
            }
        }
        System.out.println("The contestants were: ");
        list.print(list.getHead().getNext());
    }
}

