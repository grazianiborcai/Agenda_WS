package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelectDaemon;

final class VisiCusMergeDaemon extends ActionVisitorTemplateMergeV2<CusInfo, UserInfo> {
	
	public VisiCusMergeDaemon(DeciTreeOption<CusInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelectDaemon.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return UserCopier.copyFromCusDaemon(baseInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return CusMerger.mergeWithDaemon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
