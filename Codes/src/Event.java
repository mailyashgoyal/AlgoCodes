import java.util.ArrayList;
public class Event {

	double time;            // Time at which Event takes place
	int type;               // Type of Event
	Event next;             // Points to next event in list
	Event(double t, int i) {
		time = t;
		type = i;
		next = null;
	}
}

class EventList {
	//ArrayList<Event> Ev  = new ArrayList<Event>();

	Event head;           // Points to first Event in EventList
	int event_count;       // Total number of Events in EventList

	// ~EventList() { clear();}
	EventList() { event_count = 0; head = null;}
	void insert(double time, int type)  // Insert new event into EventList
	{
		event_count++;                        // Increment number of events in list.
		Event eptr = new Event(time, type);
		if (head == null) {                      // If EventList is empty, 
			head = eptr;                        // put new event at head of list.
			eptr.next = null;
		}
		else if (head.time >= eptr.time) {  // If the event is earlier than
			eptr.next = head;                  // all existing events, place it
			head = eptr;                        // at the head of the list.
		}
		else {                                // Otherwise, search for the
			Event eindex;                      // correct location sorted by time. 
			eindex = head;
			while (eindex.next != null) {
				if (eindex.next.time < eptr.time) {
					eindex = eindex.next;
				}
				else {
					break;
				}
			}
			eptr.next = eindex.next;
			eindex.next = eptr;
		}
	}
	Event get()                        // Returns first Event in EventList
	{
		if (event_count == 0) {
			return null;
		}
		else {
			event_count--;
			Event eptr;
			eptr = head;
			head = head.next;
			eptr.next = null;
			return eptr;
		}
	}
	void clear()                        // Removes all Events from EventList
	{
		Event eptr;
		while(head != null)
		{
			eptr = head;
			head = head.next;
			eptr.next = null;
			//delete eptr;
			eptr =null;
		}
		event_count = 0;
	}
	Event remove(int type)             // Returns first Event of given type
	{
		if (event_count == 0 || head == null) {
			return null;
		}
		else {
			
			Event eptr;
			Event eptr_prev = null;
			eptr = head;

			while(eptr != null){
				if (eptr.type == type) {
					if (eptr_prev == null) {
						head = eptr.next;
						eptr.next = null;
						return eptr;
					}
					else {
						eptr_prev.next = eptr.next;
						eptr.next = null;
						return eptr;
					}
				}
				else {
					eptr_prev = eptr;
					eptr = eptr.next;
				}
			}
			return null;
		}
	}
}

