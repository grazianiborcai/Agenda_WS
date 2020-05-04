package br.com.mind5.webhook.moipMultipayment.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelectDaemon;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipMerger;

final class VisiWokaymoipMergeDaemon extends ActionVisitorTemplateMergeV2<WokaymoipInfo, UserInfo> {
	
	public VisiWokaymoipMergeDaemon(DeciTreeOption<WokaymoipInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelectDaemon.class;
	}
	
	
	
	@Override protected List<WokaymoipInfo> mergeHook(List<WokaymoipInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return WokaymoipMerger.mergeWithDaemon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
