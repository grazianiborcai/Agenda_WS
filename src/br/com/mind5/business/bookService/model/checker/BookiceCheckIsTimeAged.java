package br.com.mind5.business.bookService.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.TimeAge;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class BookiceCheckIsTimeAged extends ModelCheckerTemplateSimpleV2<BookiceInfo> {

	public BookiceCheckIsTimeAged(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BookiceInfo recordInfo, Connection conn, String schemaName) {	
		if (isAged(recordInfo))			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	private boolean isAged(BookiceInfo recordInfo) {
		return new TimeAge().isAged(recordInfo.date, recordInfo.beginTime);
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BOOK_SERVICE_AGED_DATE;
	}
}
