package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class OrderVisiUserSnap implements InfoMergerVisitor_<OrderInfo, UserSnapInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo merge(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		OrderInfo resultInfo = makeClone(sourceTwo);
		resultInfo.codPerson = sourceOne.codPerson;
		resultInfo.codCustomer = sourceOne.codCustomer;
		
		return resultInfo;
	}
	
	
	
	private OrderInfo makeClone(OrderInfo recordInfo) {
		try {
			return (OrderInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(UserSnapInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner	&&
				sourceOne.codUser 		== sourceTwo.codUser	&&
				sourceOne.codSnapshot 	== sourceTwo.codSnapshot		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
