package br.com.mind5.security.userSnapshot.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.info.UserapMerger;

final class VisiUserapMergeToSelect extends ActionVisitorTemplateMergeV2<UserapInfo, UserapInfo> {
	
	public VisiUserapMergeToSelect(DeciTreeOption<UserapInfo> option) {
		super(option, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<UserapInfo>> getActionClassHook() {
		return StdUserapDaoSelect.class;
	}
	
	
	
	@Override protected List<UserapInfo> mergeHook(List<UserapInfo> baseInfos, List<UserapInfo> selectedInfos) {	
		return UserapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
