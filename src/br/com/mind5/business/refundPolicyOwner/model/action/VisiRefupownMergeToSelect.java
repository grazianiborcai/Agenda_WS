package br.com.mind5.business.refundPolicyOwner.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwner.info.RefupownMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupownMergeToSelect extends ActionVisitorTemplateMergeV2<RefupownInfo, RefupownInfo> {
	
	public VisiRefupownMergeToSelect(DeciTreeOption<RefupownInfo> option) {
		super(option, RefupownInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<RefupownInfo>> getActionClassHook() {
		return StdRefupownDaoSelect.class;
	}
	
	
	
	@Override protected List<RefupownInfo> mergeHook(List<RefupownInfo> baseInfos, List<RefupownInfo> selectedInfos) {	
		return RefupownMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
