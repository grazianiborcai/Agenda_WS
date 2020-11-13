package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergeToSelect extends ActionVisitorTemplateMerge<UserapInfo, UserapInfo> {
	
	public VisiUserapMergeToSelect(DeciTreeOption<UserapInfo> option) {
		super(option, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserapInfo>> getActionClassHook() {
		return StdUserapDaoSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<UserapInfo> selectedInfos) {	
		return UserapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
