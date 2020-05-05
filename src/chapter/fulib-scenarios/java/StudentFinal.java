// class:Student
class Student {
// attribute:name
	private String name;
// gap:

// method:getName()
	String getName() {
		return this.name;
	}
// gap:

// method:manualCode(String)
	void manualCode(String param) {
        ...
	}
// gap:

// attribute:PROPERTY_name
	public static final String PROPERTY_name = "name";
// gap:

// method:setName(String)
	Student setName(String name) {
		this.name = name;
		return this;
	}
// endclass:
}
