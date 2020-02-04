package br.com.mind5.business.orderList.info;

import java.util.List;

import br.com.mind5.business.masterData.info.CurrencyInfo;
import br.com.mind5.business.masterData.info.OrderStatusInfo;
import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class OrdistMerger {	
	public static OrdistInfo mergeWithOrdarch(OrdarchInfo sourceOne, OrdistInfo sourceTwo) {
		InfoMerger_<OrdistInfo, OrdarchInfo> merger = new OrdistMergerOrdarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdistInfo> mergeWithOrdarch(List<OrdarchInfo> sourceOnes, List<OrdistInfo> sourceTwos) {
		InfoMerger_<OrdistInfo, OrdarchInfo> merger = new OrdistMergerOrdarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdistInfo mergeWithCurrency(CurrencyInfo sourceOne, OrdistInfo sourceTwo) {
		InfoMerger_<OrdistInfo, CurrencyInfo> merger = new OrdistMergerCurrency();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdistInfo> mergeWithCurrency(List<CurrencyInfo> sourceOnes, List<OrdistInfo> sourceTwos) {
		InfoMerger_<OrdistInfo, CurrencyInfo> merger = new OrdistMergerCurrency();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdistInfo mergeWithOrderStatus(OrderStatusInfo sourceOne, OrdistInfo sourceTwo) {
		InfoMerger_<OrdistInfo, OrderStatusInfo> merger = new OrdistMergerOrderStatus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdistInfo> mergeWithOrderStatus(List<OrderStatusInfo> sourceOnes, List<OrdistInfo> sourceTwos) {
		InfoMerger_<OrdistInfo, OrderStatusInfo> merger = new OrdistMergerOrderStatus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdistInfo mergeToSelect(OrdistInfo sourceOne, OrdistInfo sourceTwo) {
		InfoMerger_<OrdistInfo, OrdistInfo> merger = new OrdistMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdistInfo> mergeToSelect(List<OrdistInfo> sourceOnes, List<OrdistInfo> sourceTwos) {
		InfoMerger_<OrdistInfo, OrdistInfo> merger = new OrdistMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
