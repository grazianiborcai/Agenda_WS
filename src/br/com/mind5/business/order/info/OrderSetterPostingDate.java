package br.com.mind5.business.order.info;

import java.time.LocalDate;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class OrderSetterPostingDate extends InfoSetterTemplate<OrderInfo> {
	
	@Override protected OrderInfo setAttrHook(OrderInfo recordInfo) {
		recordInfo.postingDate = DefaultValue.localDateNow();		
		recordInfo.postingYearMonth = getYearMonth(recordInfo.postingDate);
		recordInfo.postingYear = recordInfo.postingDate.getYear();
		
		return recordInfo;
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
}
