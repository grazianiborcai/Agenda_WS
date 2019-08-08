package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisiMergeToUpdate implements InfoMergerVisitor<OrderInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(OrderInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrderInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo merge(OrderInfo sourceOne, OrderInfo sourceTwo) {
		OrderInfo result = makeClone(sourceOne);		
		result.codPayOrder = sourceTwo.codPayOrder;
		result.codPayPartner = sourceTwo.codPayPartner;
		result.statusOrderPartner = sourceTwo.statusOrderPartner;
		result.statusPaymentPartner = sourceTwo.statusPaymentPartner;
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OrderInfo sourceOne, OrderInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
