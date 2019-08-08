package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisiMergeOrderem implements InfoMergerVisitor<OrderInfo, OrderemInfo> {

	@Override public OrderInfo writeRecord(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private OrderInfo merge(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.orderms.add(sourceOne);
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrderemInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codOrder == sourceTwo.codOrder	);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
