package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.checker.SchederveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckSchederve extends ModelCheckerTemplateForward<BookiceInfo, SchederveInfo> {
	
	public BookiceCheckSchederve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchederveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchederveCheckExist(option);
	}
	
	
	
	@Override protected SchederveInfo toForwardClass(BookiceInfo baseRecord) {
		return SchederveInfo.copyFrom(baseRecord);
	}
}
