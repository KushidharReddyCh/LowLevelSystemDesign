package notification_pattern;

public interface Observer {
	
	void update();
	void update(Subject subject);
	String getName();
}

