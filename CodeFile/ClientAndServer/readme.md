* 客户端和服务器端的读 写操作都是一样的
* 读要一直读，所以用while( true )
* 写可以设置条件停止 我用的是while( scanner.nextLine != "stop )
* 读写放在两个不同的线程
