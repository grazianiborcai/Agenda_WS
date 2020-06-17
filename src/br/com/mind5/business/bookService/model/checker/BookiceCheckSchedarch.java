package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.scheduleSearch.info.SchedarchInfo;
import br.com.mind5.business.scheduleSearch.model.checker.SchedarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckSchedarch extends ModelCheckerTemplateForwardV2<BookiceInfo, SchedarchInfo> {
	
	public BookiceCheckSchedarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchedarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedarchCheckExist(option);
	}
	
	
	
	@Override protected SchedarchInfo toForwardClass(BookiceInfo baseRecord) {
		return SchedarchInfo.copyFrom(baseRecord);
	}
}
