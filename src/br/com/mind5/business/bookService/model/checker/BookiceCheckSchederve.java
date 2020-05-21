package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.business.scheduleReserve.model.checker.SchederveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckSchederve extends ModelCheckerTemplateForwardV2<BookiceInfo, SchederveInfo> {
	
	public BookiceCheckSchederve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchederveInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchederveCheckExist(option);
	}
	
	
	
	@Override protected SchederveInfo toForwardClass(BookiceInfo baseRecord) {
		return SchederveInfo.copyFrom(baseRecord);
	}
}
