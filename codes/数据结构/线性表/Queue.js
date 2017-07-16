//队列的实现，依赖LinkedList.js
function Queue(funcCompare){
    this.list=new LinkedList();
    this.funcCompare=funcCompare;
}
//入队
Queue.prototype.enqueue=function(data){
    //如果有元素大小比对函数，则按顺序插入到队列中
  if(this.funcCompare){
   var i=0;
    while(i<this.list.size()){
        var m=this.list.get(i);
        var order=this.funcCompare(data,m);
        if(order<=0){
            break;
        }
        i++;
    }
    this.list.add(data,i);
  }else{
   this.list.add(data);
  }
}
//出队
Queue.prototype.dequeue=function(){
   var obj=null
   if(this.list.size()>0){
       var idx=0;
       obj= this.list.get(idx);
       this.list.removeByIdx(idx);
    }
    return obj;
}
//获取队头元素
Queue.prototype.getHead=function(idx){
     if(this.list.size()>0){
       var idx=0;
       return this.list.get(idx);
    }
    return null;
}
//获取当前队大小
Queue.prototype.size=function(){
    return this.list.size();
}
