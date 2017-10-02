abstract class Colleague{
    void sendMsg(String to,def msg){
        mediator.operation(this.name,to,msg)
    }
    void broadcastMsg(def msg){
       mediator.operationBroadcast(this.name,msg)
    }
    abstract void receiveMsg(String from,def msg)
    
    Mediator mediator
    String name
}

class ConcreteColleague extends Colleague{
    void receiveMsg(String from,def msg){
        println "${from}对${this.name}说:${msg}"
    }
}

abstract class Mediator{
   abstract void register(Colleague colleague)
   abstract void operation(String from,String to,def msg)
   abstract void operationBroadcast(String from,def msg)
}
class ConcreteMediator extends Mediator{
   def mapColls=[:]

   void register(Colleague colleague){
       mapColls[colleague.name]=colleague
       colleague.mediator=this
   }
   void operation(String from,String to,def msg){
        def fromObj=mapColls[from]
        def toObj=mapColls[to]
	if(fromObj&&toObj){
	    toObj.receiveMsg(from,msg)
	}else{
            println "${from} or ${to} not find!"
	}
   }

   void operationBroadcast(String from,def msg){
      mapColls.each {entry->
           entry.value.receiveMsg(from,msg)
      }
   }
}

def coll1=new ConcreteColleague(name:'小明')
def coll2=new ConcreteColleague(name:'小红')
def coll3=new ConcreteColleague(name:'王红玲')

def mediator=new ConcreteMediator()

mediator.register(coll1)
mediator.register(coll2)
mediator.register(coll3)

coll1.sendMsg('小红','今天天气真好')
coll3.sendMsg('小红','我们去迋街吧?')

println '------'
coll2.broadcastMsg('今天下午开会啦')


