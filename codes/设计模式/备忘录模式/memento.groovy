class Originator{
	String state

	Memento saveStateToMemento(){
		new Memento(state:this.state)
	}
	void getStateFromMemento(Memento m){
		this.state=m.state
	}
}
class Memento{
	String state
}

class CareTaker {
	private List<Memento> mementoList = []

	public void add(Memento state){
		mementoList.add(state)
	}

	public Memento get(int index){
		return mementoList.get(index)
	}
	public Memento pop(){
		Memento m=mementoList[-1]
		mementoList.remove(m)
		return m
	}
}
Originator originator = new Originator();
CareTaker careTaker = new CareTaker();
originator.setState("State #1");
originator.setState("State #2");
careTaker.add(originator.saveStateToMemento());
originator.setState("State #3");
careTaker.add(originator.saveStateToMemento());
originator.setState("State #4");

System.out.println("Current State: " + originator.getState());
originator.getStateFromMemento(careTaker.pop());
System.out.println("First saved State: " + originator.getState());
originator.getStateFromMemento(careTaker.pop());
System.out.println("Second saved State: " + originator.getState());

