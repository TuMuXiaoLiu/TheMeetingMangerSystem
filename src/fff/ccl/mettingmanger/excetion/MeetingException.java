/**
 * 
 */
package fff.ccl.mettingmanger.excetion;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年5月25日 下午1:16:56
 * @version 1.8
 * @since
 * @parameter
 * @PS 会议管理系统的异常基类
 */
public class MeetingException extends Exception {

	public MeetingException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MeetingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MeetingException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MeetingException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MeetingException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
