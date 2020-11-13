package br.com.mind5.business.customer.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiCusMergeUsername extends ActionVisitorTemplateMerge<CusInfo, UsernameInfo> {
	
	public VisiCusMergeUsername(DeciTreeOption<CusInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<CusInfo> baseInfos) {
		return UsernameCopier.copyFromCus(baseInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> baseInfos, List<UsernameInfo> selectedInfos) {	
		return CusMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
