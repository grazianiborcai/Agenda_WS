package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargCopier;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckStolarg extends ModelCheckerTemplateForward<BookiceInfo, StolargInfo> {
	
	public BookiceCheckStolarg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StolargInfo> getCheckerHook(ModelCheckerOption option) {
		return new StolargCheckExist(option);
	}
	
	
	
	@Override protected StolargInfo toForwardClass(BookiceInfo baseRecord) {
		return StolargCopier.copyFromBookice(baseRecord);
	}
}
