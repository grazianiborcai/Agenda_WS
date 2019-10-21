package br.com.mind5.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.orderSnapshot.info.OrdnapInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class OrderVisiMergeOrdnap implements InfoMergerVisitor<OrderInfo, OrdnapInfo> {

	@Override public OrderInfo writeRecord(OrdnapInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		OrderInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrdnapInfo sourceOne, OrderInfo sourceTwo) {
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
	
	
	
	private OrderInfo merge(OrdnapInfo sourceOne, OrderInfo sourceTwo) {
		sourceTwo.codSnapshot = sourceOne.codSnapshot;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrdnapInfo sourceOne, OrderInfo sourceTwo) {		
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codOrder == sourceTwo.codOrder		); 
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
