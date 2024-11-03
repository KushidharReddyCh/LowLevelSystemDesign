package notification_pattern;
import java.util.*;

public class ConcreteSubject implements Subject{
	private String name;
	
	List<Observer> observerList = new ArrayList<>();
	
	public ConcreteSubject(String name) {
		this.name = name;
	}
	
	public void attach(Observer observer) {
		System.out.println("attached observer");
		observerList.add(observer);
	}
	public void detach(Observer observer) {
		observerList.remove(observer);	
		System.out.println("attached removed");
	}
	
    public void notify_all() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
    
    public void notify_all_with_subject_details() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
    
    public String getName() {
    	return this.name; 
    }
	
}

//public class ConcreteSubject {
//
//}
