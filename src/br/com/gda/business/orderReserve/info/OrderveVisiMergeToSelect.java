package br.com.gda.business.orderReserve.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderveVisiMergeToSelect implements InfoMergerVisitor<OrderveInfo, OrderveInfo> {

	@Override public OrderveInfo writeRecord(OrderveInfo sourceOne, OrderveInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(OrderveInfo sourceOne, OrderveInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderveInfo merge(OrderveInfo sourceOne, OrderveInfo sourceTwo) {
		OrderveInfo result = makeClone(sourceOne);		
		result.username = sourceTwo.username;
		result.codLanguage = sourceTwo.codLanguage;
		return result;
	}
	
	
	
	private OrderveInfo makeClone(OrderveInfo recordInfo) {
		try {
			return (OrderveInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(OrderveInfo sourceOne, OrderveInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
