package br.com.mind5.business.cart.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CartSetterCurrency implements InfoSetter<CartInfo> {
	
	public CartInfo setAttr(CartInfo recordInfo) {
		checkArgument(recordInfo);
		return setCurrency(recordInfo);
	}
	
	
	
	private void checkArgument(CartInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CartInfo setCurrency(CartInfo recordInfo) {
		recordInfo.codCurr = "BRL";
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
