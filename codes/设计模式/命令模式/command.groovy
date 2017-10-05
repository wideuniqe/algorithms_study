class Receiver{
	void method1(){
		println "method1"
	}
	void method2(){
		println "method2"
	}
	void method3(){
		println "method3"
	}
}

abstract class  Command{
	abstract void execute()
}
class   GroupCommand extends Command{
	def cmds=[]
	void execute(){
		cmds.each {
			cmd->
			cmd.execute()
		}
	}
}

class ConcreteCommand1 extends Command{
	Receiver receiver
	void execute(){
		receiver.method1()
	}
}
class ConcreteCommand2 extends Command{
	Receiver receiver
	void execute(){
		receiver.method2()
	}
}
class ConcreteCommand3 extends Command{
	Receiver receiver
	void execute(){
		receiver.method3()
	}
}

class Invoker{
	Command cmd
	void executeCmd(){
		cmd.execute()
	}
}

Receiver r= new Receiver()
Invoker i=new Invoker()

def cmd1=new ConcreteCommand1(receiver:r)
def cmd2=new ConcreteCommand2(receiver:r)
def cmd3=new ConcreteCommand3(receiver:r)

i.setCmd(cmd1)
i.executeCmd()

i.setCmd(new GroupCommand(cmds:[cmd1,cmd2,cmd3]))
i.executeCmd()

