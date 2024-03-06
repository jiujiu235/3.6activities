import java.time.LocalDate;  
import java.util.ArrayList;  
import java.util.Scanner;  
  
public class Event {  
    private String eventID;  
    private String eventName;  
    private String eventVenue;  
    private LocalDate eventDate;  
    private ArrayList<String> eventAttendees;  

    public Event() {  
        this.eventAttendees = new ArrayList<>();  }  
    

    public void setEventID(String eventID) {  
        this.eventID = eventID;   }  
    public String getEventID() {  
        return eventID;  }  
    public void setEventName(String eventName) {  
        this.eventName = eventName;   }  
    public String getEventName() {  
        return eventName;   }  
    public void setEventVenue(String eventVenue) {  
        this.eventVenue = eventVenue;   }  
    public String getEventVenue() {  
        return eventVenue;  }  
    public void setEventDate(LocalDate eventDate) {  
        this.eventDate = eventDate;   }  
    public LocalDate getEventDate() {  
        return eventDate;  }   
    public void addAttendee(String attendeeName) {  
        eventAttendees.add(attendeeName);  }  
    public void removeAttendee(String attendeeName) {  
        eventAttendees.remove(attendeeName);  }  
  

    public void updateAttendee(String oldName, String newName) {  
        for (int i = 0; i < eventAttendees.size(); i++) {  
            if (eventAttendees.get(i).equals(oldName)) {  
                eventAttendees.set(i, newName);  
                break;  
            }  
        }  
    }  
  
    public String findAttendee(String attendeeName) {  
        for (String name : eventAttendees) {  
            if (name.equals(attendeeName)) {  
                return name;  
            }  
        }  
        return null;  
    }  
  

    public int getAttendeeCount() {  
        return eventAttendees.size();  }  
  

    public void organizeEvent() {  
        Scanner scanner = new Scanner(System.in);  
  
        System.out.print("Enter the event ID: ");  
        setEventID(scanner.nextLine());  
  
        System.out.print("Enter the event name: ");  
        setEventName(scanner.nextLine());  
  
        System.out.print("Enter the event venue: ");  
        setEventVenue(scanner.nextLine());  
  
        System.out.print("Enter the event date (YYYY-MM-DD): ");  
        String dateInput = scanner.nextLine();  
        setEventDate(LocalDate.parse(dateInput));  
  
        String input;  
        System.out.println("Enter the names of the attendees (enter 'done' to finish):");  
        while (!(input = scanner.nextLine()).equals("done")) {  
            addAttendee(input);  
        }  
  
        displayEventDetails();  
  
        scanner.close();  
    }  
  

    public void displayEventDetails() {  
        System.out.println("Event Details:");  
        System.out.println("Event ID: " + getEventID());  
        System.out.println("Event Name: " + getEventName());  
        System.out.println("Event Venue: " + getEventVenue());  
        System.out.println("Event Date: " + getEventDate());  
        System.out.println("Total Attendees: " + getAttendeeCount());  
        System.out.println("Attendees:");  
        for (String attendee : eventAttendees) {  
            System.out.println(attendee);  
        }  
    }  
  
    @Override  
    public String toString() {  
        return "Event{" +  
                "eventID='" + eventID + '\'' +  
                ", eventName='" + eventName + '\'' +  
                ", eventVenue='" + eventVenue + '\'' +  
                ", eventDate=" + eventDate +  
                ", eventAttendees=" + eventAttendees +  
                '}';  
    }  
  
    public static void main(String[] args) {  
        Event event = new Event();  
        event.organizeEvent();  
        System.out.println(event.toString());
    }
}