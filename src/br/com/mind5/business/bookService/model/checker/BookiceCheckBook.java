package br.com.mind5.business.bookService.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class BookiceCheckBook extends ModelCheckerTemplateSimpleV2<BookiceInfo> {

	public BookiceCheckBook(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BookiceInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.codUser		<= 0 	
			|| recordInfo.codStore 		<= 0
			|| recordInfo.codMat		<= 0
			|| recordInfo.quantity		<= 0
			|| recordInfo.date			== null 
			|| recordInfo.username		== null 
			|| recordInfo.codLanguage	== null	)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.BOOK_SERVICE_MANDATORY_FIELD_EMPTY;
	}
}
