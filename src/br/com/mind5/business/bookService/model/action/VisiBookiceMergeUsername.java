package br.com.mind5.business.bookService.model.action;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.bookService.info.BookiceMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiBookiceMergeUsername extends ActionVisitorTemplateMergeV2<BookiceInfo, UsernameInfo> {
	
	public VisiBookiceMergeUsername(DeciTreeOption<BookiceInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<BookiceInfo> baseInfos) {
		return UsernameCopier.copyFromBookice(baseInfos);
	}
	
	
	
	@Override protected List<BookiceInfo> mergeHook(List<BookiceInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return BookiceMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
