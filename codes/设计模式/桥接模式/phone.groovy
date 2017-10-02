
abstract class PhoneBrand{
	void run(){
		this._run()
		soft.run()
	}
	abstract void _run()
	
	PhoneSoft soft
}
class HuaweiPhone extends PhoneBrand{
	void _run(){
		print "华为手机" 
	}
}
class XiaomiPhone extends PhoneBrand{
	void _run(){
		print "小米手机"
	}
}
abstract class PhoneSoft{
	abstract void run()
	String name
}

class QQSoft extends PhoneSoft{
	void run(){
		print("QQ")
	}
}
class WeixinSoft extends PhoneSoft{
	void run(){
		print("Weixin")
	}
}

PhoneBrand hwqq=new HuaweiPhone(soft:new QQSoft())
hwqq.run()
println ""
PhoneBrand xmwx=new XiaomiPhone(soft:new WeixinSoft())
xmwx.run()
println ""