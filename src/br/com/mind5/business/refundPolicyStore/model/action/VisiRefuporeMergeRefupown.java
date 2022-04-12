package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RefupownRootSelectFallback;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeMergeRefupown extends ActionVisitorTemplateMerge<RefuporeInfo, RefupownInfo> {
	
	public VisiRefuporeMergeRefupown(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupownInfo>> getTreeClassHook() {
		return RefupownRootSelectFallback.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		return RefuporeMerger.mergeWithRefupown(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
