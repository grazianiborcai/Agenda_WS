package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.decisionTree.RootRefugroupDefault;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownMergeDefault extends ActionVisitorTemplateMergeV2<RefupownInfo, RefugroupInfo> {
	
	public VisiRefupownMergeDefault(DeciTreeOption<RefupownInfo> option) {
		super(option, RefugroupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefugroupInfo>> getTreeClassHook() {
		return RootRefugroupDefault.class;
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		return RefupownMerger.mergeWithRefugroup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
