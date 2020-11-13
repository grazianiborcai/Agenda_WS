package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.business.materialSearch.model.checker.MatarchCheckExistService;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckMatarchService extends ModelCheckerTemplateForward<BookiceInfo, MatarchInfo> {
	
	public BookiceCheckMatarchService(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatarchCheckExistService(option);
	}
	
	
	
	@Override protected MatarchInfo toForwardClass(BookiceInfo baseRecord) {
		return MatarchInfo.copyFrom(baseRecord);
	}
}
