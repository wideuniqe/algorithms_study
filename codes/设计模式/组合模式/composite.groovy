abstract class Component{
	String name
	abstract void display(int deepth)
	abstract void add(Component c)
}

class LeafComponent extends Component{
	LeafComponent(String name){
		this.name=name
	}
	void display(int deepth){
		println "-"*deepth+name
	}
	void add(Component c){
		println "LeafComponent cannot add component!!"
	}
}
class CompositeComponent extends Component{
	List childrens=[]
	CompositeComponent(String name){
		this.name=name
	}
	void display(int deepth){
		println "-"*deepth+name
		for(Component c:childrens){
			c.display(deepth+1)
		}
	}
	void add(Component c){
		childrens.add(c)
	}
}

Component genernateComponent(File f){
	if(f.isDirectory()){
		Component c=new CompositeComponent(f.name)
		for(File subF:f.listFiles()){
			Component subC=genernateComponent(subF)
			c.add(subC)
		}
		return c
		
	}else{
		Component c=new LeafComponent(f.name)
		return c
	}
}

File f=new File("/")
Component root=genernateComponent(f)
root.display(0)

