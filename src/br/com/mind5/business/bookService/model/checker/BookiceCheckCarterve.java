package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.checker.OrderveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckCarterve extends ModelCheckerTemplateForwardV2<BookiceInfo, OrderveInfo> {
	
	public BookiceCheckCarterve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OrderveInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderveCheckExist(option);
	}
	
	
	
	@Override protected OrderveInfo toForwardClass(BookiceInfo baseRecord) {
		return OrderveInfo.copyFrom(baseRecord);
	}
}
