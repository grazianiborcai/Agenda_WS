package br.com.mind5.business.cart.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoMergerVisitor;

final class CartVisiMergeFeewner implements InfoMergerVisitor<CartInfo, FeewnerInfo> {

	@Override public CartInfo writeRecord(FeewnerInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FeewnerInfo sourceOne, CartInfo sourceTwo) {
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
	
	
	
	private CartInfo merge(FeewnerInfo sourceOne, CartInfo sourceTwo) {
		sourceTwo.feeService = sourceOne.price;
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FeewnerInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner	&&
				sourceOne.codCurr.equals(sourceTwo.codCurr)		);
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
