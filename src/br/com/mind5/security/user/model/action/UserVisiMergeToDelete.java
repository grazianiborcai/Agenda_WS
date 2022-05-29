package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

public final class UserVisiMergeToDelete extends ActionVisitorTemplateMerge<UserInfo, UserInfo> {
	
	public UserVisiMergeToDelete(DeciTreeOption<UserInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<UserInfo>> getVisitorClassHook() {
		return UserVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return UserMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
