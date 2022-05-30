package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

public final class UserapVisiMergeToSelect extends ActionVisitorTemplateMerge<UserapInfo, UserapInfo> {
	
	public UserapVisiMergeToSelect(DeciTreeOption<UserapInfo> option) {
		super(option, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<UserapInfo>> getVisitorClassHook() {
		return UserapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<UserapInfo> selectedInfos) {	
		return UserapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
