package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.decisionTree.RootRefupownarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownMergeRefupownarch extends ActionVisitorTemplateMergeV2<RefupownInfo, RefupownarchInfo> {
	
	public VisiRefupownMergeRefupownarch(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupownarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupownarchInfo>> getTreeClassHook() {
		return RootRefupownarchSelect.class;
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefupownarchInfo> selectedInfos) {
		return RefupownMerger.mergeWithRefupownarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
