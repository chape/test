package lombok;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
/**
 * 通过注解实现在编译期将getsetter/log加到class中
 * @author ChaoChao
 *
 */
@Data
@Slf4j
public class TestLombok {

	private String            hbaseKey;
	private int               receiverCount;
	
	public static void main(String[] args) {
		TestLombok tl = new TestLombok();
		tl.getHbaseKey();
		String accessKeyId ="";
		String accessKeySecret="";
		String securityToken="";
		log.debug("AccessKeyId:{},AccessKeySecret:{},SecurityToken:{}",accessKeyId,accessKeySecret,securityToken);
	}
}
