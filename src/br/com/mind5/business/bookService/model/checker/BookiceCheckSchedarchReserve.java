package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckExistReserve;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class BookiceCheckSchedarchReserve extends ModelCheckerTemplateForward<BookiceInfo, SchedarchInfo> {
	
	public BookiceCheckSchedarchReserve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedarchCheckExistReserve(option);
	}
	
	
	
	@Override protected SchedarchInfo toForwardClass(BookiceInfo baseRecord) {
		return SchedarchInfo.copyFrom(baseRecord);
	}
}
