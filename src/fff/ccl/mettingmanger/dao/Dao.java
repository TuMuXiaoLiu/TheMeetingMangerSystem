package fff.ccl.mettingmanger.dao;

/**
 * @author caochunlin E-mail: caochunlin@chinasofti.com
 * @date 创建时间：2017年5月24日 上午10:59:34
 * @version 1.8
 * @since
 * @PS 增删改查的接口
 */
public interface Dao {
	boolean insert(Object object);
	boolean update(Object object);
	Object selectById();
	Object selectByIdPassword();
}
