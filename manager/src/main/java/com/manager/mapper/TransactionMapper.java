package com.manager.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.manager.domain.Commodity;
import com.manager.domain.Merchant;
import com.manager.domain.User;

public interface TransactionMapper {
	@Select("select `transaction`.OState "
			+ "from `transaction`,product,`merchant` "
			+ "where OId=#{id} "
			+ "and `transaction`.PId=product.PId "
			+ "and product.MId=`merchant`.MId "
			+ "and `merchant`.MId=#{mer.MId}")
	public Integer selectTransactionStateByOderId(
			@Param("id")int id,
			@Param("mer")Merchant mer);
	
	@Update("update transaction set OState=2 where OId=#{id}")
	public Integer updateState(@Param("id")int id);
	
	
	/**
	 * method for admin
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "from `transaction`,product "
			+ "where `transaction`.PId=product.PId "
				+ "and `transaction`.OTime BETWEEN #{start} and #{end}")
	public Long selectAllProductAmountBetweenSomeTimes(
			@Param("start")String start,
			@Param("end")String end);
	
	/**
	 * method for merchant
	 * @param start
	 * @param end
	 * @param mer
	 * @return
	 */
	@Select("select SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "from `transaction`,product,`merchant` "
			+ "where `transaction`.PId=product.PId "
				+ "and `transaction`.OTime BETWEEN #{start} and #{end} "
				+ "and `product`.MId=`merchant`.MId "
				+ "and `merchant`.MAccount=#{mer.MAccount}")
	public Long selectAllProductAmountBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end,
			@Param("mer")Merchant mer);
	
	/**
	 * method for admin
	 * @param start
	 * @param end
	 * @return
	 */
	@Select("select count(OId) "
			+ "from transaction "
			+ "where OTime BETWEEN #{start} and #{end}")
	public Long selectAllOrderQuantityBetweenSomeTimes(
			@Param("start")String start,
			@Param("end")String end);
	
	/**
	 * method for merchant
	 * @param start
	 * @param end
	 * @param mer
	 * @return
	 */
	@Select("select count(`transaction`.OId) "
			+ "from `transaction`,product,`merchant` "
			+ "where OTime BETWEEN #{start} and #{end} "
			+ "and transaction.PId=product.PId "
			+ "and product.MId=`merchant`.MId "
			+ "and `merchant`.MAccount=#{mer.MAccount}")
	public Long selectAllOrderQuantityBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end,
			@Param("mer")Merchant mer);
	
	
	@Select("SELECT COUNT(`transaction`.OId) "
			+ "FROM sclass,product,`transaction` "
			+ "WHERE `transaction`.PId=product.PId "
				+ "AND product.SId=sclass.SId "
				+ "AND sclass.SId=#{id} ")
	public Long selectProductQuantityBySecondclassBetweenSomeTimes(
			@Param("id")int fid);
	
	@Select("SELECT COUNT(`transaction`.OId) "
			+ "FROM sclass,product,`transaction`,`merchant` "
			+ "WHERE `transaction`.PId=product.PId "
				+ "AND product.SId=sclass.SId "
				+ "AND sclass.SId=#{id} "
				+ "and `product`.MId=`merchant`.MId "
				+ "and `merchant`.MAccount=#{mer.MAccount}")
	public Long selectProductQuantityBySecondclassBetweenSomeTime(
			@Param("id")int fid,
			@Param("mer")Merchant mer);
	
	@Select("SELECT SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "FROM sclass,product,`transaction` "
			+ "WHERE `transaction`.PId=product.PId "
				+ "AND product.SId=sclass.SId "
				+ "AND sclass.SId=#{id}")
	public Long selectProductAmountBySecondclassBetweenSomeTimes(
			@Param("id")int sid);
	
	@Select("SELECT SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "FROM sclass,product,`transaction`,`merchant` "
			+ "WHERE `transaction`.PId=product.PId "
				+ "AND product.SId=sclass.SId "
				+ "AND sclass.SId=#{id} "
				+ "and `product`.MId=`merchant`.MId "
				+ "and `merchant`.MAccount=#{mer.MAccount}")
	public Long selectProductAmountBySecondclassBetweenSomeTime(
			@Param("id")int sid,
			@Param("mer")Merchant mer);
	
	@Select("SELECT product.* "
			+ "FROM `transaction`,product "
			+ "WHERE `transaction`.PId=product.PId "
			+ "GROUP BY `transaction`.PId "
			+ "ORDER BY SUM(`transaction`.PQuanlity) DESC "
			+ "LIMIT 10;")
	public List<Commodity> selectTopTenSalesCommoditys();
	
	@Select("SELECT product.* "
			+ "FROM `transaction`,product,`merchant` "
			+ "WHERE `transaction`.PId=product.PId "
			+ "and `product`.MId=`merchant`.MId "
			+ "and `merchant`.MAccount=#{mer.MAccount} "
			+ "GROUP BY `transaction`.PId "
			+ "ORDER BY SUM(`transaction`.PQuanlity) DESC "
			+ "LIMIT 10;")
	public List<Commodity> selectTopTenSalesCommodity(@Param("mer")Merchant mer);
	
	@Select("SELECT product.*"
			+ "FROM `transaction`,product,`comment`"
			+ "WHERE `transaction`.PId = product.PId "
			+ "AND `comment`.OId = `transaction`.OId "
			+ "GROUP BY `transaction`.PId "
			+ "HAVING SUM(`transaction`.PQuanlity) > #{limit} "
			+ "ORDER BY SUM(`comment`.CScore) / COUNT(`transaction`.PQuanlity) DESC "
			+ "LIMIT 10")
	public List<Commodity> selectTopTenItemsCommoditys(@Param("limit")int limit);
	
	@Select("SELECT product.* "
			+ "FROM `transaction`,product,`comment`,`merchant` "
			+ "WHERE `transaction`.PId = product.PId "
			+ "AND `comment`.OId = `transaction`.OId "
			+ "and `product`.MId=`merchant`.MId "
			+ "and `merchant`.MAccount=#{mer.MAccount} "
			+ "GROUP BY `transaction`.PId "
			+ "HAVING SUM(`transaction`.PQuanlity) > 10 "
			+ "ORDER BY SUM(`comment`.CScore) / COUNT(`transaction`.PQuanlity) DESC "
			+ "LIMIT 10")
	public List<Commodity> selectTopTenItemsCommodity(
			@Param("limit")int limit,
			@Param("mer")Merchant mer);
	
	/*
	 * 以下为管理员具有的功能
	 * 
	 */
	
	@Select("SELECT merchant.*, COUNT(`transaction`.OId) "
			+ "FROM `transaction`,product,merchant "
			+ "WHERE `transaction`.PId = product.PId "
				+ "AND product.MId = merchant.MId "
			+ "GROUP BY merchant.MId "
			+ "ORDER BY COUNT(`transaction`.OId) DESC "
			+ "LIMIT #{limit}")
	public Map<Merchant,Integer> selectAllOrderQuantityByMerchant(
			@Param("limit") int limit);
	
	@Select("select count(`transaction`.OId) from `transaction`,product,`merchant` "
			+ "where `transaction`.PId=product.PId and product.MId=`merchant`.MId and `merchant`.MId=#{id}")
	public Long selectOrderQuantityByMerchant(@Param("id")int id);
	
	@Select("select SUM(`transaction`.PQuanlity) * product.PPrise from `transaction`,product,`merchant` "
			+ "where `transaction`.PId=product.PId and product.MId=`merchant`.MId and `merchant`.MId=#{id}")
	public Long selectOrderAmountByMerchant(@Param("id")int id);
	
	@Select("SELECT merchant.*"
			+ "FROM `transaction`,product,merchant "
			+ "WHERE `transaction`.PId = product.PId "
				+ "AND product.MId = merchant.MId "
				+ "AND `transaction`.OTime BETWEEN #{start} and #{end} "
			+ "GROUP BY merchant.MId "
			+ "ORDER BY SUM(`transaction`.PQuanlity) * product.PPrise DESC "
			+ "LIMIT #{limit}")
	public List<Merchant> selectAllProductAmountBymerchantBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end,
			@Param("limit") int limit);
	
	@Select("SELECT `user`.* "
			+ "FROM `user`,product,`transaction` "
			+ "WHERE `transaction`.PId = product.PId "
				+ "AND `transaction`.UId = USER .UId "
				+ "AND `transaction`.OTime BETWEEN #{start} and #{end} "
			+ "GROUP BY `user`.UId "
			+ "ORDER BY SUM(`transaction`.PQuanlity) * product.PPrise DESC "
			+ "LIMIT 10")
	public List<User> selectTopTenUsersBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end,
			@Param("limit") int limit);
	
	@Select("SELECT merchant.*, COUNT(`transaction`.OId) "
			+ "FROM `transaction`,product,merchant "
			+ "WHERE `transaction`.PId = product.PId "
				+ "AND product.MId = merchant.MId "
				+ "AND `transaction`.OTime BETWEEN #{start} AND #{end} "
				+ "GROUP BY merchant.MAccount "
				+ "ORDER BY COUNT(`transaction`.OId) DESC")
	public Map<Merchant,Integer> selectMerchantSaleQuantityBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end);
				
	@Select("SELECT merchant.*, SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "FROM `transaction`,product,merchant "
			+ "WHERE `transaction`.PId = product.PId "
				+ "AND product.MId = merchant.MId "
				+ "AND `transaction`.OTime BETWEEN #{start} AND #{end} "
				+ "GROUP BY merchant.MAccount "
				+ "ORDER BY SUM(`transaction`.PQuanlity) * product.PPrise DESC")
	public Map<Merchant,Integer> selectMerchantSaleAmountBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end);
}
