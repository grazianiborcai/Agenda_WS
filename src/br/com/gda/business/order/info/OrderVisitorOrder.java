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
		if (sourceOne.codOwner != sourceTwo.codOwner)
			throw new IllegalArgumentException("codOwner" + SystemMessage.ARGUMENT_DONT_MATCH);
		
		if (sourceOne.codCustomer != sourceTwo.codCustomer)
			throw new IllegalArgumentException("codCustomer" + SystemMessage.ARGUMENT_DONT_MATCH);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			throw new IllegalStateException(e); 
		}
	}
}
