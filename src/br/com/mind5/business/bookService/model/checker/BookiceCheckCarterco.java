package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.business.cartReserve.model.checker.CarterveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckCarterco extends ModelCheckerTemplateForwardV2<BookiceInfo, CarterveInfo> {
	
	public BookiceCheckCarterco(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CarterveInfo> getCheckerHook(ModelCheckerOption option) {
		return new CarterveCheckExist(option);
	}
	
	
	
	@Override protected CarterveInfo toForwardClass(BookiceInfo baseRecord) {
		return CarterveInfo.copyFrom(baseRecord);
	}
}
