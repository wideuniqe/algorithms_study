//简单工厂

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

abstract class ProductFactory{
	static Product createProduct(String name){
		if('a'==name){
			return new ConcreteProductA()
		}else if('b'==name){
			return new ConcreteProductB()
		}
		return null
	}
}


Product product

product=ProductFactory.createProduct('a')
product.use()

product=ProductFactory.createProduct('b')
product.use()
