package br.com.gda.business.orderItem.info;

import java.util.List;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class OrderMergerSnap extends InfoMerger_<OrderInfo, SnapInfo, OrderInfo> {
	public OrderInfo merge(SnapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisiSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<SnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisiSnap());
	}
}
