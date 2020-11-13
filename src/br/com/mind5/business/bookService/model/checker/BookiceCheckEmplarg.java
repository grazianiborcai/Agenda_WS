package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargCopier;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.business.employeeLeaveDateRange.model.checker.EmplargCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckEmplarg extends ModelCheckerTemplateForward<BookiceInfo, EmplargInfo> {
	
	public BookiceCheckEmplarg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmplargInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmplargCheckExist(option);
	}
	
	
	
	@Override protected EmplargInfo toForwardClass(BookiceInfo baseRecord) {
		return EmplargCopier.copyFromBookice(baseRecord);
	}
}
