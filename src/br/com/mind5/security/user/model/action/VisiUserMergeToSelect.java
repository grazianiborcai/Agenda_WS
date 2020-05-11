package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

final class VisiUserMergeToSelect extends ActionVisitorTemplateMergeV2<UserInfo, UserInfo> {
	
	public VisiUserMergeToSelect(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class); 
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<UserInfo>> getActionClassHook() {
		return StdUserDaoSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return UserMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
