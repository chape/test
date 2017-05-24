package proxy.log;

/**
 * 
 * @author kevin
 * @time 2016年5月30日 上午7:48:24
 * @desc 结算实现
 */
@LogAnnotation
public class ISettleServiceImpl implements ISettleService {

	@Override
	public void settle(String id, String source, String target, int money) {
		System.out.println("执行结算完毕，插入对应的收支明细中");  

	}

	@Override
	public Object load(Integer id) {
		 System.out.println("从数据库查询了id为["+id+"]的数据信息!");  
	     return null;  
	}

}
