package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class OrderVisiCartSnap implements InfoMergerVisitor<OrderInfo, CartSnapInfo, OrderInfo> {

	@Override public OrderInfo writeRecord(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		return merge(sourceOne, sourceTwo);
	}
	
	
	
	private void checkArgument(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private OrderInfo merge(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		OrderInfo resultInfo = sourceTwo;
		resultInfo.cartSnaps.add(makeClone(sourceOne));
		
		return resultInfo;
	}
	
	
	
	private CartSnapInfo makeClone(CartSnapInfo recordInfo) {
		try {
			return (CartSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	@Override public boolean shouldWrite(CartSnapInfo sourceOne, OrderInfo sourceTwo) {
		return (sourceOne.codOwner  	== sourceTwo.codOwner	&&
				sourceOne.codUser 		== sourceTwo.codUser	&&
				sourceOne.codSnapshot 	== sourceTwo.codSnapshot		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
