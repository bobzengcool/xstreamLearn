20241212：第一次自己创建maven项目，记录一下。
20241212：定义了一个基类，此基类可以使用xstream库将本身转换为xml报文，其子类也可以使用此方法。存在的问题，报文中有head部分和body部分，如何在创建对应的报文时候，直接不用单独再创建一个body类
20241216:成功将对象转换为报文，但是报文转化为对象一直不成功，后续在查
生成的报文为：
<service>
  <head>
    <version>headVersion</version>
    <trancode>headCode</trancode>
  </head>
  <body>
    <jydm>4694</jydm>
    <jysm>测试通过注解生辰xml报文</jysm>
    <jyrq>20241216</jyrq>
  </body>
</service>
20241218:基本上实现了报文的序列化以及反序列化，但是如果将报文节点上的class属性去掉就没有办法成功返序列化
20241229:验证了仅使用注解无法直接实现既不将集合设置为隐式节点，又能为集合中的元素设置别名为myElement 。@XStreamImplicit(itemFieldName = "myElement") 这个注解的主要作用就是将集合设置为隐式集合，并为集合中的元素指定别名
20250106:工程中引入了hibernate-validator框架，在生成xml报文之前对传入的泛型类进行校验。同时对于传入的泛型类的里面的成员对象进行嵌套校验。