package br.com.mind5.business.bookService.info;

import br.com.mind5.common.SystemCode;
import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class BookiceSetterSymsgL10 extends InfoSetterTemplate<BookiceInfo> {
	
	@Override protected BookiceInfo setAttrHook(BookiceInfo recordInfo) {
		recordInfo.symsgData = new SymsgInfo();
		
		recordInfo.symsgData.codLanguage = recordInfo.codLanguage;
		recordInfo.symsgData.codMsg = SystemCode.EMP_LDATE_RANGE_NOT_FOUND;
		
		return recordInfo;
	}
}
