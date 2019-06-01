package br.com.gda.business.orderItem.info;

import java.util.List;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class OrderMergerUserSnap extends InfoMerger_<OrderInfo, UserSnapInfo, OrderInfo> {
	public OrderInfo merge(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisiUserSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<UserSnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisiUserSnap());
	}
}
