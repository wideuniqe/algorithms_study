//线性表的链式存储结构
//因为js没的指针，所以使用静态链表的实现
//sj32
// StaticListP start
//静态链表
function StaticListP(){
    this.ary=[];
    this.freeIdxs=[];//已释放的结点编号
}
//分配一个结点，返回对应的编号
StaticListP.prototype.alloc=function(){
    var i;
    if(this.freeIdxs.length>0){
        i=this.freeIdxs.pop();
    }else{
        i=this.ary.length;
    }
    return i;
}
//释放一个结点
StaticListP.prototype.free=function(idx){
    this.ary[idx]=undefined;
    this.freeIdxs.push(idx);
}
//获取结点编号对应的数据
StaticListP.prototype.getObj=function(idx){
    return this.ary[idx];
}
//设置结点编号对应的数据
StaticListP.prototype.setObj=function(idx,value){
    this.ary[idx]=value;
}

// StaticListP end
function LinkedNode(){
    this.data=undefined;
    this.next=undefined;
}
function LinkedList(){
    this.staticList=new StaticListP();
    this.length=0;
    this.next=undefined;
}
//结尾添加数据
LinkedList.prototype.add=function(data,idx){
    var pointer=this.staticList.alloc();
    var node=new LinkedNode();
    node.data=data;
    node.next=undefined;
    this.staticList.setObj(pointer,node);

    if(idx==undefined){
        idx=this.size();//添加到末尾
    }
    if(idx<0||idx>this.size()){
        throw "idx is outbound!";
    }
    var p=undefined;
    var pObj=this;
    for(var i=0;i<idx;i++){
        p=pObj.next;
        pObj=this.staticList.getObj(p);//获取结点信息
        
    }
    node.next=pObj.next;
    pObj.next=pointer;
    
    this.length++;
}
LinkedList.prototype.addAll=function(list){
    for(var i=0;i<list.size();i++){
        this.add(list.get(i));
    }
}
LinkedList.prototype.get=function(idx){
    if(idx>=0&&idx<this.length){
        var p=undefined;
        var pObj=this;
        for(var i=0;i<=idx;i++){
            p=pObj.next;
            pObj=this.staticList.getObj(p);//获取结点信息
        }
        return pObj.data;
    }else{
        return undefined;
    }
}
LinkedList.prototype.removeByIdx=function(idx){
    if(idx>=0&&idx<this.length){
        var p=undefined;
        var qObj=pObj=this;
        for(var i=0;i<=idx;i++){
            qObj=pObj;
            p=pObj.next;
            pObj=this.staticList.getObj(p);//获取结点信息
        }
        qObj.next=pObj.next;
        this.staticList.free(p);
        this.length--;
        return true;
    }else{
        return false;
    }
}
LinkedList.prototype.size=function(){
    //通过遍历链表的方式获取长度
    var p=undefined;
    var pObj=this;
    var length=0;
    while(pObj.next!=undefined){
        p=pObj.next;
        pObj=this.staticList.getObj(p);
        length++;
    }
    return length;

    //直接返回对应的长度信息
   // return this.length;
}
//是否包含指定的数据
LinkedList.prototype.contains=function(data){
   return this.indexOf(data)>=0;
}
LinkedList.prototype.indexOf=function(data){
    for(var i=0;i<this.size();i++){
        if(this.get(i)==data){
            return i;
        }
    }
    return -1;
}
LinkedList.prototype.createIterator=function(){
    var self=this;
    // LinkedList iterator
    function Iterator(){
        this.cursor=0;
    }
    Iterator.prototype.hasNext=function(){
        var cur=this.cursor;
        if(cur<self.size()){
            return true;
        }
        return false;
    }
    Iterator.prototype.next=function(){
        if(this.hasNext()){
            return self.get(this.cursor++);
        }
        return null;
    }
    return new Iterator();
}