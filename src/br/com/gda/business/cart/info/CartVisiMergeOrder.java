package br.com.gda.business.cart.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisiMergeOrder implements InfoMergerVisitor<CartInfo, OrderInfo> {

	@Override public CartInfo writeRecord(OrderInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(OrderInfo sourceOne, CartInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CartInfo makeClone(CartInfo recordInfo) {
		try {
			return (CartInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}
	
	
	
	private CartInfo merge(OrderInfo sourceOne, CartInfo sourceTwo) {
		sourceTwo.codOrder = sourceOne.codOrder;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(OrderInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
