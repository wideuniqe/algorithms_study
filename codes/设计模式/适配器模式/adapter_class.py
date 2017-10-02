'''
Created on 2017年10月2日
Adapter class 实现方式，通过多继承
@author: shen
'''

#调用的目标类
class Target(object):
    def request(self,msg):
        pass
#需要匹配的类
class Adaptee(object):
    def __init__(self,name):
        self.__name=name
        
    def myhelloworld(self,msg):
        print("%s say hello %s" % (self.__name,msg) )
#实现的匹配器
class TargetAdapter(Target,Adaptee):
    def request(self,msg):
        self.myhelloworld(msg)

#调用匹配器上target对应的方法
target=TargetAdapter('小红')
target.request("小生")