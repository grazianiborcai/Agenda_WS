package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.business.orderReserve.model.checker.OrderveCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckOrderve extends ModelCheckerTemplateForward<BookiceInfo, OrderveInfo> {
	
	public BookiceCheckOrderve(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<OrderveInfo> getCheckerHook(ModelCheckerOption option) {
		return new OrderveCheckExist(option);
	}
	
	
	
	@Override protected OrderveInfo toForwardClass(BookiceInfo baseRecord) {
		return OrderveInfo.copyFrom(baseRecord);
	}
}
