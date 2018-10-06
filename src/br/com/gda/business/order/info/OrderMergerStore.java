package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerStore extends InfoMerger<OrderInfo, StoreInfo, OrderInfo> {
	public OrderInfo merge(StoreInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorStore());
	}
	
	
	
	public List<OrderInfo> merge(List<StoreInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorStore());
	}
}
