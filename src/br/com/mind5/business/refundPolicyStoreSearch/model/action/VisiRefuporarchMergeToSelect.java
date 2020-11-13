package br.com.mind5.business.refundPolicyStoreSearch.model.action;

import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiRefuporarchMergeToSelect extends ActionVisitorTemplateMerge<RefuporarchInfo, RefuporarchInfo> {
	
	public VisiRefuporarchMergeToSelect(DeciTreeOption<RefuporarchInfo> option) {
		super(option, RefuporarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<RefuporarchInfo>> getActionClassHook() {
		return StdRefuporarchDaoSelect.class;
	}
	
	
	
	@Override protected List<RefuporarchInfo> mergeHook(List<RefuporarchInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {	
		return RefuporarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
