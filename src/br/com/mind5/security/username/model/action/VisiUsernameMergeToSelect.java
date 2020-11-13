package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.info.UsernameMerger;

final class VisiUsernameMergeToSelect extends ActionVisitorTemplateMerge<UsernameInfo, UsernameInfo> {
	
	public VisiUsernameMergeToSelect(DeciTreeOption<UsernameInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UsernameInfo>> getActionClassHook() {
		return StdUsernameDaoSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return UsernameMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
