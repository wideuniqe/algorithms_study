abstract class ProductA{
	abstract void use()
}
class ConcreteProductA1 extends ProductA{
	void use(){
		println "use ${this.getClass().name}"
	}
}
class ConcreteProductA2 extends ProductA{
	void use(){
		println "use ${this.getClass().name}"
	}
}

abstract class ProductB{
	abstract void use()
}
class ConcreteProductB1 extends ProductB{
	void use(){
		println "use ${this.getClass().name}"
	}
}
class ConcreteProductB2 extends ProductB{
	void use(){
		println "use ${this.getClass().name}"
	}
}

abstract class ProductFactory{
	abstract ProductA createProductA(String name)
	abstract ProductB createProductB(String name)
}
class ConcreteProductFactory extends ProductFactory{
	ProductA createProductA(String name){
		if('1'==name){
			return new ConcreteProductA1()
		}else if('2'==name){
			return new ConcreteProductA2()
		}
		return null
	}
	
	ProductB createProductB(String name){
		if('1'==name){
			return new ConcreteProductB1()
		}else if('2'==name){
			return new ConcreteProductB2()
		}
		return null
	}
}


ProductFactory factory=null
ProductA productA=null
ProductB productB=null

factory=new ConcreteProductFactory()
productA=factory.createProductA('1')
productA.use()

productB=factory.createProductB('2')
productB.use()