package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.decisionTree.RootUserarchSelectUsername;

public final class CusVisiMergeUserarch extends ActionVisitorTemplateMerge<CusInfo, UserarchInfo> {
	
	public CusVisiMergeUserarch(DeciTreeOption<CusInfo> option) {
		super(option, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserarchInfo>> getTreeClassHook() {
		return RootUserarchSelectUsername.class;
	}
	
	
	
	@Override protected List<UserarchInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return UserarchCopier.copyFromCus(baseInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return CusMerger.mergeWithUserarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
