package br.com.gda.business.cart.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CartVisiMergeFeedef implements InfoMergerVisitorV2<CartInfo, FeedefInfo> {

	@Override public CartInfo writeRecord(FeedefInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo clonedInfo = makeClone(sourceTwo);
		return merge(sourceOne, clonedInfo);
	}
	
	
	
	private void checkArgument(FeedefInfo sourceOne, CartInfo sourceTwo) {
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
	
	
	
	private CartInfo merge(FeedefInfo sourceOne, CartInfo sourceTwo) {
		if (sourceOne.price > 0)
			sourceTwo.feeService = sourceOne.price;
		
		return sourceTwo;
	}
	
	
	
	@Override public boolean shouldWrite(FeedefInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codCurr.equals(sourceTwo.codCurr));
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
