package br.com.gda.business.cartItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoMergerVisitorV2;

final class CartVisiMergeCurrency implements InfoMergerVisitorV2<CartInfo, CurrencyInfo> {

	@Override public CartInfo writeRecord(CurrencyInfo sourceOne, CartInfo sourceTwo) {
		checkArgument(sourceOne, sourceTwo);
		
		CartInfo resultInfo = makeClone(sourceTwo);
		resultInfo.txtCurr = sourceOne.txtCurr;

		return resultInfo;
	}
	
	
	
	private void checkArgument(CurrencyInfo sourceOne, CartInfo sourceTwo) {
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


	
	@Override public boolean shouldWrite(CurrencyInfo sourceOne, CartInfo sourceTwo) {
		return (sourceOne.codCurr.equals(sourceTwo.codCurr));
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
