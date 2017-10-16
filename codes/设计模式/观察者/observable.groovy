import java.util.Observable;

class Subject extends Observable {
	String message;
	void setMessage(String message){
		this.message=message;
		setChanged()
		notifyObservers("message")
	}
}

class ConcreteObserverA implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		println "${this.getClass().name}->[${arg}]->${o.message}"
	}
}
class ConcreteObserverB implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		println "${this.getClass().name}->[${arg}]->${o.message}"
	}
}

Subject s=new Subject()
def oA=new ConcreteObserverA();
def oB=new ConcreteObserverB();

s.addObserver(oA)
s.addObserver(oB)

s.setMessage("你好")

s.setMessage("沈阳")

s.deleteObserver(oB)
s.setMessage("中国")
