package br.com.mind5.security.userSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.info.UserarchMerger;

final class VisiUserarchMergeToSelect extends ActionVisitorTemplateMerge<UserarchInfo, UserarchInfo> {
	
	public VisiUserarchMergeToSelect(DeciTreeOption<UserarchInfo> option) {
		super(option, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserarchInfo>> getActionClassHook() {
		return StdUserarchDaoSelect.class;
	}
	
	
	
	@Override protected List<UserarchInfo> mergeHook(List<UserarchInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return UserarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
