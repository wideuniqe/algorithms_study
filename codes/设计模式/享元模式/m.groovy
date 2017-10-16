//享元
abstract class Flyweight {
	String name
	abstract void operation(def outstate)
}
class ConcreteFlyweight extends Flyweight{
	void operation(def outstate){
		println "${name} say: ${outstate}"
	}
}
@Singleton(lazy=true)
class FlyweightFactory{

	def flyweights=[:]
	Flyweight getFlyweight(String name){
		def o=flyweights[name];
		if(!o){
			o=new ConcreteFlyweight(name:name)
			flyweights[name]=o
		}
		return o
	}
	int flyweightCounts(){
		flyweights.size()
	}
}

Flyweight f1=FlyweightFactory.getInstance().getFlyweight("小红")
Flyweight f2=FlyweightFactory.instance.getFlyweight("小丽")
Flyweight f3=FlyweightFactory.instance.getFlyweight("小红")

f1.operation("haha")
f2.operation("haha")
f3.operation("haha")

println "counts:${FlyweightFactory.instance.flyweightCounts()}"
println f1.is(f2)
println f1.is(f3)
