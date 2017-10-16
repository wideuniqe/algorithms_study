//工厂方法

abstract class Product{
	abstract void use()
}
class ConcreteProductA extends Product{
	void use(){
		println "use ${this.getClass().name}"
	}
}
class ConcreteProductB  extends Product{
	void use(){
		println "use ${this.getClass().name}"
	}
}

class ConcreteProduct1 extends Product{
	void use(){
		println "use ${this.getClass().name}"
	}
}
class ConcreteProduct2  extends Product{
	void use(){
		println "use ${this.getClass().name}"
	}
}

abstract class ProductFactory{
	abstract Product createProduct(String name)
}
class ConcreteProductFactoryAB extends ProductFactory{
	Product createProduct(String name){
		if('a'==name){
			return new ConcreteProductA()
		}else if('b'==name){
			return new ConcreteProductB()
		}
		return null
	}
}

class ConcreteProductFactory12 extends ProductFactory{
	Product createProduct(String name){
		if('1'==name){
			return new ConcreteProduct1()
		}else if('2'==name){
			return new ConcreteProduct2()
		}
		return null
	}
}

ProductFactory factory=null
Product product=null

factory=new ConcreteProductFactoryAB()
product=factory.createProduct('a')
product.use()

factory=new ConcreteProductFactory12()
product=factory.createProduct('1')
product.use()