package br.com.mind5.business.cart.info;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.common.TotAmount;
import br.com.mind5.info.InfoSetter;

public final class CartSetterItemtotal implements InfoSetter<CartInfo> {
	
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
				recordInfo.itemTotal = eachCartem.totitem;
			} else {
				recordInfo.itemTotal = totAmount.computeTotal(recordInfo.itemTotal, eachCartem.totitem);
			}
			
			counter = counter + 1;
		}
		
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
