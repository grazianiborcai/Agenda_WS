package br.com.mind5.webhook.pagarmeHook.model.action;

import java.util.List;


import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootSelectDaemon;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.info.PagookMerger;

public final class PagookVisiMergeDaemon extends ActionVisitorTemplateMerge<PagookInfo, UserInfo> {
	
	public PagookVisiMergeDaemon(DeciTreeOption<PagookInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootSelectDaemon.class;
	}
	
	
	
	@Override protected List<PagookInfo> mergeHook(List<PagookInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return PagookMerger.mergeWithDaemon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
