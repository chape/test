package proxy.log;

/**
 * 
 * @author kevin
 * @time 2016年5月30日 上午7:46:09
 * @desc 结算接口
 */
public interface ISettleService {
	//简单举例
	@LogAnnotation("annotation注解日志信息")  
    public void settle(String id,String source,String target,int money );  
    //@LogAnnotation("test")  
    public Object load(Integer id);  //无注解

}
