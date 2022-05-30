package br.com.mind5.security.username.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.info.UsernameMerger;

public final class UsernameVisiMergeToSelect extends ActionVisitorTemplateMerge<UsernameInfo, UsernameInfo> {
	
	public UsernameVisiMergeToSelect(DeciTreeOption<UsernameInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<UsernameInfo>> getVisitorClassHook() {
		return UsernameVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return UsernameMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
