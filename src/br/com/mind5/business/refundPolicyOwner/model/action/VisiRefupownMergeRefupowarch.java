package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchCopier;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.decisionTree.RootRefupowarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownMergeRefupowarch extends ActionVisitorTemplateMergeV2<RefupownInfo, RefupowarchInfo> {
	
	public VisiRefupownMergeRefupowarch(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupowarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<RefupowarchInfo>> getTreeClassHook() {
		return RootRefupowarchSelect.class;
	}
	
	
	
	@Override protected List<RefupowarchInfo> toActionClassHook(List<RefupownInfo> baseInfos) {
		return RefupowarchCopier.copyFromRefupown(baseInfos);	
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefupowarchInfo> selectedInfos) {
		return RefupownMerger.mergeWithRefupowarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
