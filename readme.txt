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