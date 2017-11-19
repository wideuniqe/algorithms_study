abstract class Handler{
	Handler successor
	abstract void handleRequest(int n)
}
class ConcreteHandler1 extends Handler{
	void handleRequest(int n){
		if(n<0){
			println "handle $n<0"
		}else{
			if(successor){
				successor.handleRequest(n)
			}
		}
	}
}
class ConcreteHandler2 extends Handler{
	void handleRequest(int n){
		if(n>=0&&n<=20){
			println "handle 0<=$n<=20"
		}else{
			if(successor){
				successor.handleRequest(n)
			}
		}
	}
}
class ConcreteHandler3 extends Handler{
	void handleRequest(int n){
		if(successor){
			successor.handleRequest(n)
		}else{
			println "default handle $n"
		}
	}
}

Handler h1=new ConcreteHandler1()
Handler h2=new ConcreteHandler2()
Handler h3=new ConcreteHandler3()
h1.successor=h2
h2.successor=h3
for(int i=-10;i<=30;i++){
	h1.handleRequest(i)
}

