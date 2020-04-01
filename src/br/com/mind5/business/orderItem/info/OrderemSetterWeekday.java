package br.com.mind5.business.orderItem.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderemSetterWeekday implements InfoSetter<OrderemInfo> {
	
	public OrderemInfo setAttr(OrderemInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodWeekday(recordInfo);
	}
	
	
	
	private void checkArgument(OrderemInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OrderemInfo setCodWeekday(OrderemInfo recordInfo) {
		OrderemInfo enforcedInfo = makeClone(recordInfo);
		enforcedInfo.codWeekday = enforcedInfo.date.getDayOfWeek().getValue();		
		return enforcedInfo;
	}
	
	
	
	private OrderemInfo makeClone(OrderemInfo recordInfo) {
		try {
			return (OrderemInfo) recordInfo.clone();
			
		} catch (CloneNotSupportedException e) {
			logException(e);
			throw new IllegalStateException(e); 
		}
	}	
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
