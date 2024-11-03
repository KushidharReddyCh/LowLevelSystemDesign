package notification_pattern;

import java.util.*;

public class Notification{
	
	public static void main(String args[]) {
		
		ConcreteSubject conClass = new ConcreteSubject("subject1");
		ConcreteSubject conClass2 = new ConcreteSubject("subject2");
		ConcreteObserver ob1 = new ConcreteObserver("ob1");
		ConcreteObserver ob2 = new ConcreteObserver("ob2");
		ConcreteObserver ob3 = new ConcreteObserver("ob3");
		ConcreteObserver ob4 = new ConcreteObserver("ob4");
		
		conClass.attach(ob1);
		conClass.attach(ob2);
		conClass2.attach(ob1);
		conClass2.attach(ob3);
		conClass2.attach(ob4);
		
		conClass.notify_all_with_subject_details();
		conClass2.notify_all_with_subject_details();
		
		conClass2.detach(ob4);
		conClass2.notify_all_with_subject_details();
	}
	
}

