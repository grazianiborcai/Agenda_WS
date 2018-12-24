package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerMatSnap extends InfoMerger<OrderInfo, MatSnapInfo, OrderInfo> {
	public OrderInfo merge(MatSnapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorMatSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<MatSnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorMatSnap());
	}
}
