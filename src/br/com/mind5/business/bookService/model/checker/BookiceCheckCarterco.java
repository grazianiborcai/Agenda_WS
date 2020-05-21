package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.business.cartReserveConflict.model.checker.CartercoCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckCarterco extends ModelCheckerTemplateForwardV2<BookiceInfo, CartercoInfo> {
	
	public BookiceCheckCarterco(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CartercoInfo> getCheckerHook(ModelCheckerOption option) {
		return new CartercoCheckExist(option);
	}
	
	
	
	@Override protected CartercoInfo toForwardClass(BookiceInfo baseRecord) {
		return CartercoInfo.copyFrom(baseRecord);
	}
}
