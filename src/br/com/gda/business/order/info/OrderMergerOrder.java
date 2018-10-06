package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class OrderMergerOrder extends InfoMerger<OrderInfo, OrderInfo, OrderInfo> {
	public OrderInfo merge(OrderInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorOrder());
	}
	
	
	
	public List<OrderInfo> merge(List<OrderInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorOrder());
	}
}
