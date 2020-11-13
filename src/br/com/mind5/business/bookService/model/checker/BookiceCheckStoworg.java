package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.storeWorkTimeRange.info.StoworgInfo;
import br.com.mind5.business.storeWorkTimeRange.model.checker.StoworgCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckStoworg extends ModelCheckerTemplateForward<BookiceInfo, StoworgInfo> {
	
	public BookiceCheckStoworg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StoworgInfo> getCheckerHook(ModelCheckerOption option) {
		return new StoworgCheckExist(option);
	}
	
	
	
	@Override protected StoworgInfo toForwardClass(BookiceInfo baseRecord) {
		return StoworgInfo.copyFrom(baseRecord);
	}
}
