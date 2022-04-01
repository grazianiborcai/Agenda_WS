package br.com.mind5.business.bookService.model.action;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.model.decisionTree.BookiceNodeCartemL2;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BookiceVisiNodeCartemL2 extends ActionVisitorTemplateAction<BookiceInfo, BookiceInfo> {

	public BookiceVisiNodeCartemL2(DeciTreeOption<BookiceInfo> option) {
		super(option, BookiceInfo.class, BookiceInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<BookiceInfo>> getTreeClassHook() {
		return BookiceNodeCartemL2.class;
	}
	
	
	
	@Override protected List<BookiceInfo> toBaseClassHook(List<BookiceInfo> baseInfos, List<BookiceInfo> results) {
		return results;
	}
}
