package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class OrderMerger {		
	public static OrderInfo mergeWithPayord(PayordInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, PayordInfo> merger = new OrderMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, PayordInfo> merger = new OrderMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithFeeCateg(FeeCategInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, FeeCategInfo> merger = new OrderMergerFeeCateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithFeeCateg(List<FeeCategInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, FeeCategInfo> merger = new OrderMergerFeeCateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithCurrency(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, CurrencyInfo> merger = new OrderMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, CurrencyInfo> merger = new OrderMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeWithOrderem(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, OrderemInfo> merger = new OrderMergerOrderem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithOrderem(List<OrderemInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, OrderemInfo> merger = new OrderMergerOrderem();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithOrderStatus(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, OrderStatusInfo> merger = new OrderMergerOrderStatus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithOrderStatus(List<OrderStatusInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, OrderStatusInfo> merger = new OrderMergerOrderStatus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeWithUsername(UsernameInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, UsernameInfo> merger = new OrderMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, UsernameInfo> merger = new OrderMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithUser(UserInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, UserInfo> merger = new OrderMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithUser(List<UserInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, UserInfo> merger = new OrderMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeToSelect(OrderInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, OrderInfo> merger = new OrderMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeToSelect(List<OrderInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, OrderInfo> merger = new OrderMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeToUpdate(OrderInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, OrderInfo> merger = new OrderMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeToUpdate(List<OrderInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, OrderInfo> merger = new OrderMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
