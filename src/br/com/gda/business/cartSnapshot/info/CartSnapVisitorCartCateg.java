package br.com.gda.business.cartSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CartCategInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class CartSnapVisitorCartCateg implements InfoMergerVisitor_<CartSnapInfo, CartCategInfo, CartSnapInfo> {

	@Override public CartSnapInfo writeRecord(CartCategInfo sourceOne, CartSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartSnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtItemCateg = sourceOne.txtItemCateg;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CartCategInfo sourceOne, CartSnapInfo sourceTwo) {
		if (shouldWrite(sourceOne, sourceTwo) == false)
			throw new IllegalArgumentException(SystemMessage.MERGE_NOT_ALLOWED);
	}
	
	
	
	private CartSnapInfo makeClone(CartSnapInfo recordInfo) {
		try {
			return (CartSnapInfo) recordInfo.clone();
			
		} catch (Exception e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}


	
	@Override public boolean shouldWrite(CartCategInfo sourceOne, CartSnapInfo sourceTwo) {
		return (sourceOne.codItemCateg == sourceTwo.codItemCateg);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
