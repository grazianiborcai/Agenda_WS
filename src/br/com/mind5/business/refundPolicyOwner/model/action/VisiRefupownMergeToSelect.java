package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownMergeToSelect extends ActionVisitorTemplateMerge<RefupownInfo, RefupownInfo> {
	
	public VisiRefupownMergeToSelect(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<RefupownInfo>> getActionClassHook() {
		return StdRefupownDaoSelect.class;
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefupownInfo> selectedInfos) {	
		return RefupownMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
