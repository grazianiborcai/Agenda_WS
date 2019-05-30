package br.com.gda.business.cart.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.common.TotAmount;
import br.com.gda.info.InfoSetter;

public final class CartSetterGrantotal implements InfoSetter<CartInfo> {
	
	public CartInfo setAttr(CartInfo recordInfo) {
		checkArgument(recordInfo);
		return setGrandTotal(recordInfo);
	}
	
	
	
	private void checkArgument(CartInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CartInfo setGrandTotal(CartInfo recordInfo) {
		TotAmount totAmount = new TotAmount();
		int counter = 0;
		
		for (CartemInfo eachCartem : recordInfo.cartems) {
			if (counter == 0) {
				recordInfo.grandTotal = eachCartem.totitem;
			} else {
				recordInfo.grandTotal = totAmount.computeTotal(recordInfo.grandTotal, eachCartem.totitem);
			}
			
			counter = counter + 1;
		}
		
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
