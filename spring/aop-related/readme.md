* Spring在运行期生成动态代理对像，不需要特殊的编译器  
* Spring AOP的底层就是用过JDK动态代理或CGLib动态代理技术为目标bean执行横向织入   
   1). 若目标对象是想了若干接口，spring使用jdk的java.lang.reflect.Proxy类代理  
   2). 若目标对象没有实现任何接口，spring使用CGLib库生成目标对象的子类  
程序中
* 程序中应优先对接口创建代理，便于程序解耦维护  
* 标记为final的方法不能被代理，因为无法进行覆盖  
   1). JDK动态代理，是针对接口生成子类，接口中方法不能使用final修饰  
   2). CGLib是针对目标类生产子类，因此类或方法不能使用final修饰
* Spring只支持方法连接点，不提供属性连接
