package br.com.mind5.business.bookService.model.action;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.info.BookiceSetterSymsgL14;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BookiceVisiEnforceSymsgL14 extends ActionVisitorTemplateEnforce<BookiceInfo> {
	
	public BookiceVisiEnforceSymsgL14(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected BookiceInfo enforceHook(BookiceInfo recordInfo) {
		InfoSetter<BookiceInfo> setter = new BookiceSetterSymsgL14();
		return setter.setAttr(recordInfo);
	}
}
