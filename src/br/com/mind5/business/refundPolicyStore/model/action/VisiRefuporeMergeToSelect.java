package br.com.mind5.business.refundPolicyStore.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.business.refundPolicyStore.info.RefuporeMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporeMergeToSelect extends ActionVisitorTemplateMergeV2<RefuporeInfo, RefuporeInfo> {
	
	public VisiRefuporeMergeToSelect(DeciTreeOption<RefuporeInfo> option) {
		super(option, RefuporeInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<RefuporeInfo>> getActionClassHook() {
		return StdRefuporeDaoSelect.class;
	}
	
	
	
	@Override protected List<RefuporeInfo> mergeHook(List<RefuporeInfo> baseInfos, List<RefuporeInfo> selectedInfos) {	
		return RefuporeMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
