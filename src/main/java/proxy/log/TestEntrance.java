package proxy.log;

/**
 * 
 * @author kevin
 * @time 2016年5月30日 上午8:00:24
 * @desc 测试入口
 */
public class TestEntrance {
	
	public static void main(String[] args) {  
       // ISettleService settleService = new ISettleServiceImpl();  
        //创建的动态代理对象
        //ISettleService log = (ISettleService)LogProxy.getInstance(settleService);  
        ISettleService log = (ISettleService)LogProxy.getInstance(ISettleServiceImpl.class);  
        //具体哪个会输出日志信息，请看我在接口ISettleService上的annotation注解即可。  
        //对于LogProxy这个类的写法还需要好好研究研究改进加入自己的业务中 
        log.settle("54cdcb739a0b8ad439d04b66", "12cdcb739a0b8ad439d04b66", "46cdcb739a0b8ad439d04b66", 20);//执行删除方法  
        log.load(1);//执行查询方法  
          
    }  

}
