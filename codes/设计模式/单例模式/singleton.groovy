//http://www.runoob.com/design-pattern/singleton-pattern.html
interface MySay{
	void say()
}
def compare(MySay s1,MySay s2){
	s1.say()
	s2.say()
	println "s1==s2:${s1.is(s2)}"
	println ""
}

//通过enum实现
enum Singleton implements MySay{
	INSTANCE;
	public void say() {
		println "${this}"
	}
}

compare(Singleton.INSTANCE,Singleton.INSTANCE)

//通过静态内部类
class Singleton1 implements MySay{
	private static class SingletonHolder {
		private static final Singleton1 INSTANCE = new Singleton1();
	}
	private Singleton1 (){}
	public static final Singleton1 getInstance() {
		return SingletonHolder.INSTANCE;
	}
	public void say() {
		println "${this}"
	}

}

compare(Singleton1.instance,Singleton1.instance)


class Singleton2 implements MySay{
		private volatile static Singleton2 singleton;
		private Singleton2 (){}
		public static Singleton2 getInstance() {
			if (singleton == null) {
				synchronized (Singleton2.class) {
					if (singleton == null) {
						singleton = new Singleton2();
					}
				}
			}
			return singleton;
		}
		public void say() {
			println "${this}"
		}
}
compare(Singleton2.instance,Singleton2.instance)


