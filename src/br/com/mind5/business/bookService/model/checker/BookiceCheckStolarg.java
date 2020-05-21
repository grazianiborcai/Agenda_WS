package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.storeLeaveDateRange.info.StolargCopier;
import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.business.storeLeaveDateRange.model.checker.StolargCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckStolarg extends ModelCheckerTemplateForwardV2<BookiceInfo, StolargInfo> {
	
	public BookiceCheckStolarg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<StolargInfo> getCheckerHook(ModelCheckerOption option) {
		return new StolargCheckExist(option);
	}
	
	
	
	@Override protected StolargInfo toForwardClass(BookiceInfo baseRecord) {
		return StolargCopier.copyFromBookice(baseRecord);
	}
}
