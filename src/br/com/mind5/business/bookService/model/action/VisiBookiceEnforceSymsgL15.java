package br.com.mind5.business.bookService.model.action;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.info.BookiceSetterSymsgL15;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiBookiceEnforceSymsgL15 extends ActionVisitorTemplateEnforce<BookiceInfo> {
	
	public VisiBookiceEnforceSymsgL15(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected BookiceInfo enforceHook(BookiceInfo recordInfo) {
		InfoSetter<BookiceInfo> setter = new BookiceSetterSymsgL15();
		return setter.setAttr(recordInfo);
	}
}
