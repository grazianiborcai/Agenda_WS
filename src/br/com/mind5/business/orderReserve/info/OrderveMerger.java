package br.com.mind5.business.orderReserve.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class OrderveMerger {	
	public static OrderveInfo mergeToSelect(OrderveInfo sourceOne, OrderveInfo sourceTwo) {
		InfoMerger_<OrderveInfo, OrderveInfo> merger = new OrderveMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderveInfo> mergeToSelect(List<OrderveInfo> sourceOnes, List<OrderveInfo> sourceTwos) {
		InfoMerger_<OrderveInfo, OrderveInfo> merger = new OrderveMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
