package br.com.gda.business.cartSnapshot_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.obsolete.InfoMergerVisitor_;

final class CartSnapVisitorStore implements InfoMergerVisitor_<CartSnapInfo, StoreInfo, CartSnapInfo> {

	@Override public CartSnapInfo writeRecord(StoreInfo sourceOne, CartSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartSnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.nameStore = "sourceOne.name";	//TODO: Ajustar nome
		resultInfo.codTimezone = sourceOne.codTimezone;

		return resultInfo;
	}
	
	
	
	private void checkArgument(StoreInfo sourceOne, CartSnapInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(StoreInfo sourceOne, CartSnapInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codStore == sourceTwo.codStore);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
