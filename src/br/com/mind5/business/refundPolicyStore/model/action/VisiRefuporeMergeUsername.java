package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiRefuporeMergeUsername extends ActionVisitorTemplateMerge<RefuporeInfo, UsernameInfo> {
	
	public VisiRefuporeMergeUsername(DeciTreeOption<RefuporeInfo> option) {
		super(option, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<RefuporeInfo> baseInfos) {
		return UsernameCopier.copyFromRefupore(baseInfos);	
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		return RefuporeMerger.mergeWithUsername(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
