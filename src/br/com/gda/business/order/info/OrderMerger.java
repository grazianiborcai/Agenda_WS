package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class OrderMerger {		
	public static OrderInfo mergeWithCurrency(CurrencyInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, CurrencyInfo> merger = new OrderMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, CurrencyInfo> merger = new OrderMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderInfo mergeWithCartem(CartemInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, CartemInfo> merger = new OrderMergerCartem();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeWithCartem(List<CartemInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, CartemInfo> merger = new OrderMergerCartem();		
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
	
	
	
	public static OrderInfo mergeToSelect(OrderInfo sourceOne, OrderInfo sourceTwo) {
		InfoMerger<OrderInfo, OrderInfo> merger = new OrderMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderInfo> mergeToSelect(List<OrderInfo> sourceOnes, List<OrderInfo> sourceTwos) {
		InfoMerger<OrderInfo, OrderInfo> merger = new OrderMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
}
