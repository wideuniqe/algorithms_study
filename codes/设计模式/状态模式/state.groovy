
abstract class State {
	abstract void handle(Context context)
}

class Context {
	State current
	void request(){
		current.handle(this)
	}
}

class ConcreteStateA extends State{
	void handle(Context context){
		println "ConcreteStateA handle"
		context.current=new ConcreteStateB()
	}
}
class ConcreteStateB extends State{
	void handle(Context context){
		println "ConcreteStateB handle"
		context.current=new ConcreteStateC()
	}
}
class ConcreteStateC extends State{
	void handle(Context context){
		println "ConcreteStateC handle"
		context.current=new ConcreteStateA()
	}
}
Context ctx=new Context(current:new ConcreteStateC())

0.upto(10) {
	print "$it ->"
	ctx.request()
}