package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckMat extends ModelCheckerTemplateForward<BookiceInfo, MatInfo> {
	
	public BookiceCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(BookiceInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
