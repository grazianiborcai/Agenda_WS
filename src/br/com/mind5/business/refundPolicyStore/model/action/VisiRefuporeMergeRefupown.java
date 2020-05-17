package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.model.decisionTree.RootRefupownSelectFallback;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeMergeRefupown extends ActionVisitorTemplateMergeV2<RefuporeInfo, RefupownInfo> {
	
	public VisiRefuporeMergeRefupown(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupownInfo>> getTreeClassHook() {
		return RootRefupownSelectFallback.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		return RefuporeMerger.mergeWithRefupown(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
