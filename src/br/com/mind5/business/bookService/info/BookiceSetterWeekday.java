package br.com.mind5.business.bookService.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class BookiceSetterWeekday extends InfoSetterTemplate<BookiceInfo> {
	
	@Override protected BookiceInfo setAttrHook(BookiceInfo recordInfo) {
		recordInfo.codWeekday = recordInfo.date.getDayOfWeek().getValue();		
		return recordInfo;
	}
}
