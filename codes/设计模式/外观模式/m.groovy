abstract class Facade{
  abstract void wrapOperation()
}
class ConcreteFacade extends Facade{
    void wrapOperation(){
	sub1.operation1()
	sub2.operation2()
	sub3.operation3()
    }
    SubSystem1 sub1
    SubSystem2 sub2
    SubSystem3 sub3
}

class SubSystem1{
   void operation1(){
      println 'SubSystem1 operation1'
   }
}
class SubSystem2{
   void operation2(){
      println 'SubSystem2 operation2'
   }
}
class SubSystem3{
   void operation3(){
      println 'SubSystem3 operation3'
   }
}

Facade f=new ConcreteFacade()
f.sub1=new SubSystem1()
f.sub2=new SubSystem2()
f.sub3=new SubSystem3()

f.wrapOperation()
