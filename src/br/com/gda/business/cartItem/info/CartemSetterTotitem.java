package br.com.gda.business.cartItem.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.common.TotAmount;
import br.com.gda.info.InfoSetter;

public final class CartemSetterTotitem implements InfoSetter<CartemInfo> {
	
	public CartemInfo setAttr(CartemInfo recordInfo) {
		checkArgument(recordInfo);
		return setTotitem(recordInfo);
	}
	
	
	
	private void checkArgument(CartemInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CartemInfo setTotitem(CartemInfo recordInfo) {
		TotAmount totAmount = new TotAmount();
		recordInfo.totitem = totAmount.computeTotalItem(recordInfo.price, recordInfo.quantity);
		
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
