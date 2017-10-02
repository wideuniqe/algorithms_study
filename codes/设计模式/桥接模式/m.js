//es6 实现桥接模式相关代码
//abstract 
class Implementor{
    operationImpl(){
    }
}
class ConcreteImplementorA extends Implementor{
    operationImpl(){
       console.log('ConcreteImplementorA operationImpl');
    }
}

class ConcreteImplementorB extends Implementor{
    operationImpl(){
           console.log('ConcreteImplementorB operationImpl');
    }
}

class Abstraction{
    constructor(implementor){
        this.implementor=implementor;
    }
    operation(){
        
    }
}

class RefinedAbstraction extends Abstraction{
    operation(){
        this.implementor.operationImpl()
    }
}

let abs=new RefinedAbstraction(new ConcreteImplementorA());
abs.operation();

let abs1=new RefinedAbstraction(new ConcreteImplementorB());
abs1.operation();
