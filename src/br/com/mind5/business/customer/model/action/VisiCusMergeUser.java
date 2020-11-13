package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelect;

final class VisiCusMergeUser extends ActionVisitorTemplateMerge<CusInfo, UserInfo> {
	
	public VisiCusMergeUser(DeciTreeOption<CusInfo> option) {
		super(option, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return UserCopier.copyFromCusKey(baseInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<UserInfo> selectedInfos) {	
		return CusMerger.mergeWithUser(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
