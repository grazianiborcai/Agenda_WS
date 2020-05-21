package br.com.mind5.business.bookService.model.action;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.info.BookiceSetterAged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiBookiceEnforceAged extends ActionVisitorTemplateEnforceV2<BookiceInfo> {
	
	public VisiBookiceEnforceAged(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	@Override protected BookiceInfo enforceHook(BookiceInfo recordInfo) {
		InfoSetter<BookiceInfo> setter = new BookiceSetterAged();
		return setter.setAttr(recordInfo);
	}
}
