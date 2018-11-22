package br.com.gda.business.order.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisitorOrder implements InfoMergerVisitor<OrderInfo, OrderInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(OrderInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codOrder = sourceOne.codOrder;

		return resultInfo;
	}
	
	
	
	private void checkArgument(OrderInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(OrderInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codCustomer == sourceTwo.codCustomer);
	}
}
