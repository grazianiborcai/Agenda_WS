package br.com.mind5.webhook.moipRefund.model.action;

import java.util.List;


import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.UserRootSelectDaemon;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;
import br.com.mind5.webhook.moipRefund.info.WokefumoipMerger;

public final class WokefumoipVisiMergeDaemon extends ActionVisitorTemplateMerge<WokefumoipInfo, UserInfo> {
	
	public WokefumoipVisiMergeDaemon(DeciTreeOption<WokefumoipInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return UserRootSelectDaemon.class;
	}
	
	
	
	@Override protected List<WokefumoipInfo> mergeHook(List<WokefumoipInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return WokefumoipMerger.mergeWithDaemon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
