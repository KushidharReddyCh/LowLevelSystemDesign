package notification_pattern;

public class ConcreteObserver implements Observer{
	private String name;
	public ConcreteObserver(String name) {
		this.name = name;
	}
	
	public void update() {
		System.out.println("Updated in observer");
	}
	
	public void update(Subject subject) {
		System.out.println(this.getName() + " Updated from " + subject.getName());
	}
	public String getName() {
		return this.name;
	}
}

