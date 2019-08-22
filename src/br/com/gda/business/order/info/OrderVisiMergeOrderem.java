package br.com.gda.business.order.info;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisiMergeOrderem implements InfoMergerVisitor<OrderInfo, OrderemInfo> {

	@Override public OrderInfo writeRecord(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo merge(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.orderms.add(sourceOne);
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codOrder == sourceTwo.codOrder	);
	}
}
