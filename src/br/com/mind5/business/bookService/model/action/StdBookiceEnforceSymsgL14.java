package br.com.mind5.business.bookService.model.action;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdBookiceEnforceSymsgL14 extends ActionStdTemplate<BookiceInfo> {

	public StdBookiceEnforceSymsgL14(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<BookiceInfo> buildVisitorHook(DeciTreeOption<BookiceInfo> option) {
		return new VisiBookiceEnforceSymsgL14(option);
	}
}
