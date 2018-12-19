package br.com.gda.business.order.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class OrderMergerUser extends InfoMerger<OrderInfo, UserInfo, OrderInfo> {
	public OrderInfo merge(UserInfo sourceOne, OrderInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OrderVisitorUser());
	}
	
	
	
	public List<OrderInfo> merge(List<UserInfo> sourceOnes, List<OrderInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OrderVisitorUser());
	}
}
