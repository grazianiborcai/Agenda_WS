package br.com.mind5.business.bookService.model.action;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.info.BookiceMerger;
import br.com.mind5.message.sysMessage.info.SymsgCopier;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.message.sysMessage.model.decisionTree.RootSymsgSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class BookiceVisiMergeSymsg extends ActionVisitorTemplateMerge<BookiceInfo, SymsgInfo> {
	
	public BookiceVisiMergeSymsg(DeciTreeOption<BookiceInfo> option) {
		super(option, SymsgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SymsgInfo>> getTreeClassHook() {
		return RootSymsgSelect.class;
	}
	
	
	
	@Override protected List<SymsgInfo> toActionClassHook(List<BookiceInfo> baseInfos) {
		return SymsgCopier.copyFromBookice(baseInfos);
	}
	
	
	
	@Override protected List<BookiceInfo> mergeHook(List<BookiceInfo> baseInfos, List<SymsgInfo> selectedInfos) {	
		return BookiceMerger.mergeWithSymsg(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
