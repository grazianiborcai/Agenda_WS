package br.com.mind5.business.order.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderMerger {		
	public static OrderInfo mergeWithCus(CusInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, CusInfo> merger = new OrderMergerCus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCus(List<CusInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, CusInfo> merger = new OrderMergerCus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeWithOrdnap(OrdnapInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, OrdnapInfo> merger = new OrderMergerOrdnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithOrdnap(List<OrdnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, OrdnapInfo> merger = new OrderMergerOrdnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithCusarch(CusarchInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, CusarchInfo> merger = new OrderMergerCusarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCusarch(List<CusarchInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, CusarchInfo> merger = new OrderMergerCusarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeWithPayord(PayordInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, PayordInfo> merger = new OrderMergerPayord();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithPayord(List<PayordInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, PayordInfo> merger = new OrderMergerPayord();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OrderInfo mergeWithFeeCateg(FeeCategInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, FeeCategInfo> merger = new OrderMergerFeeCateg();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithFeeCateg(List<FeeCategInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, FeeCategInfo> merger = new OrderMergerFeeCateg();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithCurrency(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, CurrencyInfo> merger = new OrderMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, CurrencyInfo> merger = new OrderMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeWithOrderem(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, OrderemInfo> merger = new OrderMergerOrderem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithOrderem(List<OrderemInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, OrderemInfo> merger = new OrderMergerOrderem();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithOrderStatus(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, OrderStatusInfo> merger = new OrderMergerOrderStatus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithOrderStatus(List<OrderStatusInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, OrderStatusInfo> merger = new OrderMergerOrderStatus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeWithUsername(UsernameInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, UsernameInfo> merger = new OrderMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, UsernameInfo> merger = new OrderMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderInfo mergeToSelect(OrderInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, OrderInfo> merger = new OrderMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeToSelect(List<OrderInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, OrderInfo> merger = new OrderMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeToUpdate(OrderInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger_<OrderInfo, OrderInfo> merger = new OrderMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeToUpdate(List<OrderInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger_<OrderInfo, OrderInfo> merger = new OrderMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
