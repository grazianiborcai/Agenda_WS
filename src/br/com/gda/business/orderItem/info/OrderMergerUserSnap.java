package br.com.gda.business.orderItem.info;

import java.util.List;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class OrderMergerUserSnap extends InfoMerger_<OrderInfo, UserapInfo, OrderInfo> {
	public OrderInfo merge(UserapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisiUserSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<UserapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisiUserSnap());
	}
}
