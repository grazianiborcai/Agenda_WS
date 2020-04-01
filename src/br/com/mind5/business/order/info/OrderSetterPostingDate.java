package br.com.mind5.business.order.info;

import java.time.LocalDate;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OrderSetterPostingDate implements InfoSetter<OrderInfo> {
	
	public OrderInfo setAttr(OrderInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.postingDate = DefaultValue.localDateNow();		
		recordInfo.postingYearMonth = getYearMonth(recordInfo.postingDate);
		recordInfo.postingYear = recordInfo.postingDate.getYear();
		
		return recordInfo;
	}
	
	
	
	private void checkArgument(OrderInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private int getYearMonth(LocalDate postingDate) {
		String year = String.valueOf(postingDate.getYear());
		String month = getMonth(postingDate);		
		String yearMonth = year + month;
		
		return Integer.valueOf(yearMonth);
	}
	
	
	
	private String getMonth(LocalDate postingDate) {
		String month = "0" + String.valueOf(postingDate.getMonthValue());		
		return month.substring(month.length()-2, month.length());
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
