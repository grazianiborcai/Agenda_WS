package br.com.mind5.business.refundPolicyOwnerSearch.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefupowarchMergeToSelect extends ActionVisitorTemplateMergeV2<RefupowarchInfo, RefupowarchInfo> {
	
	public VisiRefupowarchMergeToSelect(DeciTreeOption<RefupowarchInfo> option) {
		super(option, RefupowarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<RefupowarchInfo>> getActionClassHook() {
		return StdRefupowarchDaoSelect.class;
	}
	
	
	
	@Override protected List<RefupowarchInfo> mergeHook(List<RefupowarchInfo> baseInfos, List<RefupowarchInfo> selectedInfos) {	
		return RefupowarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
