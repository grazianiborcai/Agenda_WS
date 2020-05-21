package br.com.mind5.business.bookService.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class BookiceSetterAged extends InfoSetterTemplate<BookiceInfo> {
	
	@Override protected BookiceInfo setAttrHook(BookiceInfo recordInfo) {
		recordInfo.isAged = true;
		return recordInfo;
	}
}
