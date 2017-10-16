//建造者模式

class Product{
	def parts=[]

	void add(String part){
		parts.add(part)
	}
	void show(){
		println "--产品创建:"
		parts.each{ println it }
	}
}

abstract class Builder{
	abstract void buildPartA()
	abstract void buildPartB()
	abstract Product getProduct()
}

class ConcreteBuilder1 extends Builder{
	Product product=new Product()
	void buildPartA(){
		product.add("PartA")
	}
	void buildPartB(){
		product.add("PartB")
	}
	Product getProduct(){
		return product
	}
}

class ConcreteBuilder2 extends Builder{
	Product product=new Product()
	void buildPartA(){
		product.add("部件A")
	}
	void buildPartB(){
		product.add("部件B")
	}
	Product getProduct(){
		return product
	}
}

abstract class Director{
	abstract void construct(Builder builder)
}
class ConcreteDirector1 extends Director{
	void construct(Builder builder){
		builder.buildPartA()
		for(i in 1..2){
			builder.buildPartB()
		}
		builder.buildPartA()
	}
}

Builder builder=new ConcreteBuilder1()
Director director=new ConcreteDirector1()
director.construct(builder)
builder.getProduct().show()

builder=new ConcreteBuilder2()
director.construct(builder)
builder.getProduct().show()

