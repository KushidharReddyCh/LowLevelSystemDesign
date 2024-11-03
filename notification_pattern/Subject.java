package notification_pattern;

public interface Subject {
	
	void attach(Observer observer);
	void detach(Observer observer);
	
	void notify_all();
	void notify_all_with_subject_details();
	String getName();
}
