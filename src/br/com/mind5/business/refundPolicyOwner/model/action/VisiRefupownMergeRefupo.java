package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;
import br.com.mind5.masterData.refundPolicy.model.decisionTree.RootRefupoSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownMergeRefupo extends ActionVisitorTemplateMergeV2<RefupownInfo, RefupoInfo> {
	
	public VisiRefupownMergeRefupo(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupoInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupoInfo>> getTreeClassHook() {
		return RootRefupoSelect.class;
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		return RefupownMerger.mergeWithRefupo(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
