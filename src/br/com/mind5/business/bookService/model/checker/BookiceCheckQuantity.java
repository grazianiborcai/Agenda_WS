package br.com.mind5.business.bookService.model.checker;

import java.sql.Connection;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class BookiceCheckQuantity extends ModelCheckerTemplateSimple<BookiceInfo> {

	public BookiceCheckQuantity(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(BookiceInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.quantity != 1)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_QUANTITY_ILLEGAL;
	}
}
