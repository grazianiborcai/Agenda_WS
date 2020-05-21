package br.com.mind5.business.bookService.model.action;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdBookiceSuccess extends ActionStdSuccessTemplate<BookiceInfo> {
	
	public StdBookiceSuccess(DeciTreeOption<BookiceInfo> option) {
		super(option);
	}
}
