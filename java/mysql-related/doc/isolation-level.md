# mysql事物隔离级别  
## 脏读，不可重复读，幻读定义  
* 脏读：一个事物能够读取到另一个事物未提交的数据
* 不可重复读： 一个事物中两次读取到的数据可能不一致，**一般正对update和delete**
* 幻读：事务A首先根据条件索引得到N条数据，然后事务B改变了这N条数据之外的M条或者增添了M条符合事务A搜索条件的数据，  
  导致事务A再次搜索发现有N+M条数据了，就产生了幻读。**一般针对insert**
## Read Uncommitted(读取未提交内容)
* (1)所有事务都可以看到其他未提交事务的执行结果  
* (2)本隔离级别很少用于实际应用，因为它的性能也不比其他级别好多少  
* (3)该级别引发的问题是——脏读(Dirty Read)：读取到了未提交的数据  
## Read Committed(读取提交内容)
* (1)这是大多数数据库系统的默认隔离级别（但不是MySQL默认的）
* (2)它满足了隔离的简单定义：一个事务只能看见已经提交事务所做的改变
* (3)这种隔离级别出现的问题是——不可重复读(Nonrepeatable Read)：不可重复读意味着我们在同一个事务中执行完全相同的select语句时可能看到不一样的结果。  
     |——>导致这种情况的原因可能有：
     * (1)有一个交叉的事务有新的commit，导致了数据的改变;
     * (2)一个数据库被多个实例操作时,同一事务的其他实例在该实例处理其间可能会有新的commit  
## Repeatable Read(可重读)
* (1)这是MySQL的默认事务隔离级别
* (2)它确保同一事务的多个实例在并发读取数据时，会看到同样的数据行
* (3)此级别可能出现的问题——幻读(Phantom Read)：当用户读取某一范围的数据行时，另一个事务又在该范围内插入了新行，当用户再读取该范围的数据行时，会发现有新的“幻影” 行
* (4)InnoDB和Falcon存储引擎通过多版本并发控制(MVCC，Multiversion Concurrency Control)机制解决了该问题  
## Serializable(可串行化)
* (1)这是最高的隔离级别
* (2)它通过强制事务排序，使之不可能相互冲突，从而解决幻读问题。简言之,它是在每个读的数据行上加上共享锁。
* (3)在这个级别，可能导致大量的超时现象和锁竞争