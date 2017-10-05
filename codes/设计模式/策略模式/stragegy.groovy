//策略模式

abstract class Stragegy{
	abstract void algorithm()
}
class ConcreteStragegyA extends Stragegy{
	void algorithm(){
		println "ConcreteStragegyA"
	}
}
class ConcreteStragegyB extends Stragegy{
	void algorithm(){
		println "ConcreteStragegyB"
	}
}
class MyContext{
	void doAlgorithm(){
		stragegy.algorithm()
	}
	Stragegy stragegy
}


MyContext context=new MyContext()

context.stragegy=new ConcreteStragegyA()
context.doAlgorithm()

context.stragegy=new ConcreteStragegyB()
context.doAlgorithm()

