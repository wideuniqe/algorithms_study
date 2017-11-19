abstract class Component{
	abstract void operation()
}

class ConcreteComponent extends Component{
	void operation(){
		println "ConcreteComponent operation"
	}
}

abstract class Docorator extends Component{
	Component target
	Docorator(Component t){
		target=t
	}
	void operation(){
		target.operation()
	}
}
class ConcreteDecoratorA extends Docorator{
	String state
	ConcreteDecoratorA(Component t){
		super(t)
	}

	void operation(){
		super.operation();
		println "ConcreteDecoratorA operation $state"
	}
}

class ConcreteDecoratorB extends Docorator{
	ConcreteDecoratorB(Component t){
		super(t)
	}
	void operation(){
		super.operation();
		println "ConcreteDecoratorB operation"
	}

	void doAddition(){
		println "do Addition things"
	}
}



ConcreteComponent m=new ConcreteComponent()
ConcreteDecoratorA cA=new ConcreteDecoratorA(m)
cA.state="state111"
ConcreteDecoratorB cB=new ConcreteDecoratorB(cA)
cB.operation()
