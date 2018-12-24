package br.com.gda.business.cartSnapshot.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitor;

final class CartSnapVisitorMatSnap implements InfoMergerVisitor<CartSnapInfo, MatSnapInfo, CartSnapInfo> {

	@Override public CartSnapInfo writeRecord(MatSnapInfo sourceOne, CartSnapInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartSnapInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtMat = sourceOne.txtMat;
		resultInfo.codUnit = sourceOne.codUnit;
		resultInfo.txtUnit = sourceOne.txtUnit;
		resultInfo.priceUnit = sourceOne.priceUnit;
		resultInfo.price = sourceOne.price;
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.txtCurr = sourceOne.txtCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatSnapInfo sourceOne, CartSnapInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatSnapInfo sourceOne, CartSnapInfo sourceTwo) {
		return (sourceOne.codOwner		== sourceTwo.codOwner 		&& 
				sourceOne.codSnapshot	== sourceTwo.codSnapshot 	&& 
				sourceOne.codMat 		== sourceTwo.codMat);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
