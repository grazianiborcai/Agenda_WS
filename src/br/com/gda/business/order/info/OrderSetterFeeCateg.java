package br.com.gda.business.order.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.FeeCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OrderSetterFeeCateg implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		return setCurrency(recordInfo);
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OrderInfo setCurrency(OrderInfo recordInfo) {
		recordInfo.codFeeCateg = FeeCateg.SERVICE.getCodCateg();
		return recordInfo;
	}	
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
