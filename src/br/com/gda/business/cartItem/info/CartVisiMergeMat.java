package br.com.gda.business.cartItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CartVisiMergeMat implements InfoMergerVisitorV2<CartInfo, MatInfo> {

	@Override public CartInfo writeRecord(MatInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtMat = sourceOne.txtMat;
		resultInfo.codUnit = sourceOne.codUnit;
		resultInfo.txtUnit = sourceOne.txtUnit;
		resultInfo.priceUnit = sourceOne.priceUnit;
		resultInfo.price = sourceOne.price;
		resultInfo.codCurr = sourceOne.codCurr;
		resultInfo.txtCurr = sourceOne.txtCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(MatInfo sourceOne, CartInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(MatInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codOwner == sourceTwo.codOwner) && (sourceOne.codMat == sourceTwo.codMat);
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
