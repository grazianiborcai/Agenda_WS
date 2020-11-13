package br.com.mind5.security.userAuthentication.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userAuthentication.info.UauthInfo;
import br.com.mind5.security.userAuthentication.info.UauthMerger;
import br.com.mind5.security.userList.info.UselisCopier;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.model.decisionTree.RootUselisSearch;

final class VisiUauthMergeUselis extends ActionVisitorTemplateMerge<UauthInfo, UselisInfo> {
	
	public VisiUauthMergeUselis(DeciTreeOption<UauthInfo> option) {
		super(option, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSearch.class;
	}
	
	
	
	@Override protected List<UselisInfo> toActionClassHook(List<UauthInfo> recordInfos) {
		return UselisCopier.copyFromUauth(recordInfos);
	}
	
	
	
	@Override protected List<UauthInfo> mergeHook(List<UauthInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return UauthMerger.mergeWithUselis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
