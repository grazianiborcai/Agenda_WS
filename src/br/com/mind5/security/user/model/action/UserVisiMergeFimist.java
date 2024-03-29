package br.com.mind5.security.user.model.action;

import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.FimistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.info.UserMerger;

public final class UserVisiMergeFimist extends ActionVisitorTemplateMerge<UserInfo, FimistInfo> {
	
	public UserVisiMergeFimist(DeciTreeOption<UserInfo> option) {
		super(option, FimistInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return FimistRootSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<UserInfo> baseInfos) {
		return FimistCopier.copyFromUser(baseInfos);	
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return UserMerger.mergeWithFimist(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
