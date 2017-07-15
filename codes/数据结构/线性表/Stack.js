//栈的实现，依赖LinkedList.js
function Stack(){
    this.list=new LinkedList();
}
//入栈
Stack.prototype.push=function(data){
   this.list.add(data);
}
//出栈
Stack.prototype.pop=function(){
   var obj=null
   if(this.list.size()>0){
       var idx=this.list.size()-1;
        obj= this.list.get(idx);
        this.list.removeByIdx(idx);
    }
    return obj;
}
//获取栈顶元素
Stack.prototype.getTop=function(idx){
     if(this.list.size()>0){
       var idx=this.list.size()-1;
        return this.list.get(idx);
    }
    return null;
}
//获取当前栈大小
Stack.prototype.size=function(){
    return this.list.size();
}
