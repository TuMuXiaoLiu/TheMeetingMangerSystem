/**
 * 
 */
package fff.ccl.mettingmanger.excetion;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年6月1日 上午8:36:19
 * @version 1.8
 * @since
 * @parameter
 * @PS 当查询不到数据时会抛出此异常
 */
public class SelectException extends MeetingException {

	public SelectException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SelectException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SelectException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SelectException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
