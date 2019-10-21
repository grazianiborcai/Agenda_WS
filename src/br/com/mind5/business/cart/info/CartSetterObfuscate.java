package br.com.mind5.business.cart.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CartSetterObfuscate implements InfoSetter<CartInfo> {
	
	public CartInfo setAttr(CartInfo recordInfo) {
		checkArgument(recordInfo);
		return setObfuscate(recordInfo);
	}
	
	
	
	private void checkArgument(CartInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CartInfo setObfuscate(CartInfo recordInfo) {
		CartInfo result = new CartInfo();
		result.codOwner = recordInfo.codOwner;
		result.codOrder = recordInfo.codOrder;
		result.codLanguage = recordInfo.codLanguage;
		return result;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
