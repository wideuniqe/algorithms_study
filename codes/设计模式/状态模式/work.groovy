
abstract class WorkState {
	abstract void handle(Work work)
}

class Work {
	WorkState current
	void request(){
		current.handle(this)
	}
	int hour
	boolean finish
}

class ForenoonState extends WorkState{
	void handle(Work work){
		if(work.hour>=12){
			work.current=new NoonState()
			work.request()
		}else{
			println "努力工作中，效率最高"
		}
	}
}
class NoonState extends WorkState{
	void handle(Work work){
		if(work.hour>=13){
			work.current=new AfternoonState()
			work.request()
		}else{
			println "午休时间"
		}
	}
}
class AfternoonState extends WorkState{
	void handle(Work work){
		if(work.hour>=18){
			if(work.finish){
				work.current=new GohomeState()
			}else{
				work.current=new EveningState()
			}
			work.request()
		}else{
			println "下午有点困，效率不高"
		}
	}
}

class GohomeState extends WorkState{
	void handle(Work work){
		println "当前时间:${work.hour}点,下班啦，工作完成了吗？${work.finish?'完成了':'未完成'}"
	}
}
class EveningState extends WorkState{
	void handle(Work work){
		if(work.hour>=19){
			work.current=new ExtraWorkState()
			work.request()
		}else{
			println "加班前先去吃饭，休息一下"
		}
	}
}
class ExtraWorkState extends WorkState{
	void handle(Work work){
		if(work.finish||work.hour>=21){
			work.current=new GohomeState()
			work.request()
		}else{
			println "当前时间:${work.hour},正在加班"
		}
	}
}
Work ctx=new Work(current:new ForenoonState())

9.upto(22) {
	print "$it ->"
	ctx.hour=it
	ctx.request()
}

println "=========="

ctx=new Work(current:new ForenoonState())
9.upto(15) {
	print "$it ->"
	ctx.hour=it
	ctx.request()
}
ctx.finish=true
16.upto(21) {
	print "$it ->"
	ctx.hour=it
	ctx.request()
}