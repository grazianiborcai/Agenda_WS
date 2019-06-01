package br.com.gda.business.orderItem.info;

import java.util.List;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class OrderMergerOrderStatus extends InfoMerger_<OrderInfo, OrderStatusInfo, OrderInfo> {
	public OrderInfo merge(OrderStatusInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisiOrderStatus());
	}
	
	
	
	public List<OrderInfo> merge(List<OrderStatusInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisiOrderStatus());
	}
}
