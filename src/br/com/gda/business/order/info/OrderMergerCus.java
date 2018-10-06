package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerCus extends InfoMerger<OrderInfo, CusInfo, OrderInfo> {
	public OrderInfo merge(CusInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorCus());
	}
	
	
	
	public List<OrderInfo> merge(List<CusInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorCus());
	}
}
