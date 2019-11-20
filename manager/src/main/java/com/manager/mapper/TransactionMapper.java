package com.manager.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.manager.domain.Commodity;
import com.manager.domain.Merchant;
import com.manager.domain.User;

public interface TransactionMapper {
	
	@Select("select SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "from `transaction`,product "
			+ "where `transaction`.PId=product.PId "
				+ "and `transaction`.OTime BETWEEN #{start} and #{end}")
	public long selectAllProductAmountBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end);
	
	@Select("select count(OId) "
			+ "from transaction "
			+ "where OTime BETWEEN #{start} and #{end}")
	public long selectAllOrderQuantityBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end);
	
	@Select("SELECT COUNT(`transaction`.OId) "
			+ "FROM fclass,sclass,product,`transaction` "
			+ "WHERE `transaction`.PId=product.PId "
				+ "AND product.SId=sclass.SId "
				+ "AND sclass.FId=fclass.FId "
				+ "AND `transaction`.OTime BETWEEN #{start} and #{end} "
				+ "AND fclass.FId=#{id};")
	public long selectProductQuantityByFirstclassBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end,
			@Param("id")int fid);
	
	@Select("SELECT SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "FROM sclass,product,`transaction` "
			+ "WHERE `transaction`.PId=product.PId "
				+ "AND product.SId=sclass.SId "
				+ "AND `transaction`.OTime BETWEEN #{start} and #{end} "
				+ "AND sclass.SId=#{id}")
	public long selectProductAmountByFirstclassBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end,
			@Param("id")int sid);
	
	@Select("SELECT product.* "
			+ "FROM `transaction`,product "
			+ "WHERE `transaction`.PId=product.PId "
			+ "GROUP BY `transaction`.PId "
			+ "ORDER BY SUM(`transaction`.PQuanlity) DESC "
			+ "LIMIT 10;")
	public List<Commodity> selectTopTenSalesCommodity();
	
	@Select("SELECT product.*"
			+ "FROM `transaction`,product,`comment`"
			+ "WHERE `transaction`.PId = product.PId "
			+ "AND `comment`.OId = `transaction`.OId "
			+ "GROUP BY `transaction`.PId "
			+ "HAVING SUM(`transaction`.PQuanlity) > #{limit} "
			+ "ORDER BY SUM(`comment`.CScore) / COUNT(`transaction`.PQuanlity) DESC "
			+ "LIMIT 10")
	public List<Commodity> selectTopTenItemsCommodity(@Param("limit")int limit);
	
	
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
	
	@Select("SELECT `user`.*, SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "FROM `user`,product,merchant "
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
			+ "FROM `transaction`,product,merchant"
			+ "WHERE `transaction`.PId = product.PId"
				+ "AND product.MId = merchant.MId"
				+ "AND `transaction`.OTime BETWEEN #{start} AND #{end}"
				+ "GROUP BY merchant.MAccount"
				+ "ORDER BY COUNT(`transaction`.OId) DESC")
	public Map<Merchant,Integer> selectMerchantSaleQuantityBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end);
				
	@Select("SELECT merchant.*, SUM(`transaction`.PQuanlity) * product.PPrise "
			+ "FROM `transaction`,product,merchant"
			+ "WHERE `transaction`.PId = product.PId"
				+ "AND product.MId = merchant.MId"
				+ "AND `transaction`.OTime BETWEEN #{start} AND #{end}"
				+ "GROUP BY merchant.MAccount"
				+ "ORDER BY SUM(`transaction`.PQuanlity) * product.PPrise DESC")
	public Map<Merchant,Integer> selectMerchantSaleAmountBetweenSomeTime(
			@Param("start")String start,
			@Param("end")String end);
}
