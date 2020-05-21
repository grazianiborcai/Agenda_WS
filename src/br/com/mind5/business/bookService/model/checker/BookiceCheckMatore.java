package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckMatore extends ModelCheckerTemplateForwardV2<BookiceInfo, MatoreInfo> {
	
	public BookiceCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(BookiceInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
