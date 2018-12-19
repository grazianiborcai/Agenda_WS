package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerUserSnap extends InfoMerger<OrderInfo, UserSnapInfo, OrderInfo> {
	public OrderInfo merge(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorUserSnap());
	}
	
	
	
	public List<OrderInfo> merge(List<UserSnapInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorUserSnap());
	}
}
