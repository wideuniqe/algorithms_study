abstract class Visitor{
	abstract void visitConcreteElementA(ConcreteElementA m)
	abstract void visitConcreteElementB(ConcreteElementB m)
}
class ConcreteVisitor1 extends Visitor{
	void visitConcreteElementA(ConcreteElementA m){
		println this.getClass().name+" ->"+m.getClass().name
	}
	void visitConcreteElementB(ConcreteElementB m){
		println this.getClass().name+" ->"+m.getClass().name
	}
	
}
class ConcreteVisitor2 extends Visitor{
	void visitConcreteElementA(ConcreteElementA m){
		println this.getClass().name+" ->"+m.getClass().name
	}
	void visitConcreteElementB(ConcreteElementB m){
		println this.getClass().name+" ->"+m.getClass().name
	}
	
}

abstract class Element{
	abstract void accept(Visitor v)
}

class ConcreteElementA extends Element{
	 void accept(Visitor v){
		 v.visitConcreteElementA(this)
	 }
}
class ConcreteElementB extends Element{
	void accept(Visitor v){
		v.visitConcreteElementB(this)
	}
}

class ObjectStructure {
	List elems=[]
	void attach(Element e){
		elems.add(e)
	}
	void detatch(Element e){
		elems.remove(e)
	}
	void accept(Visitor v){
		for(Element e:elems){
			e.accept(v)
		}
	}
}

ObjectStructure o=new ObjectStructure()
Element eA=new ConcreteElementA()
Element eB=new ConcreteElementB()
o.attach(eA)
o.attach(eB)
Visitor v1=new ConcreteVisitor1() 
Visitor v2=new ConcreteVisitor1()
Visitor[] vs=[v1,v2];
for(Visitor v:vs){
	o.accept(v) 
}

