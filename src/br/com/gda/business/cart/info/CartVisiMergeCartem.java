package br.com.gda.business.cart.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartVisiMergeCartem implements InfoMergerVisitor<CartInfo, CartemInfo> {

	@Override public CartInfo writeRecord(CartemInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(CartemInfo sourceOne, CartInfo sourceTwo) {
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
	
	
	
	private CartInfo merge(CartemInfo sourceOne, CartInfo sourceTwo) {
		sourceTwo.cartems.add(sourceOne);
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(CartemInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner &&
				sourceOne.codUser  == sourceTwo.codUser		);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
