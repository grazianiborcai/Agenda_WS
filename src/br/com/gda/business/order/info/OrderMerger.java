package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class OrderMerger {		
	public static OrderInfo mergeWithOrdnap(OrdnapInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, OrdnapInfo> merger = new OrderMergerOrdnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithOrdnap(List<OrdnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, OrdnapInfo> merger = new OrderMergerOrdnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithCusarch(CusarchInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, CusarchInfo> merger = new OrderMergerCusarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCusarch(List<CusarchInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, CusarchInfo> merger = new OrderMergerCusarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
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
	
	
	
	public static OrderInfo mergeWithUselis(UselisInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, UselisInfo> merger = new OrderMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, UselisInfo> merger = new OrderMergerUselis();		
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
