package br.com.mind5.payment.payOrderSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;
import br.com.mind5.payment.payOrderSearch.info.PayordarchMerger;

final class VisiPayordarchMergeToSelect extends ActionVisitorTemplateMerge<PayordarchInfo, PayordarchInfo> {
	
	public VisiPayordarchMergeToSelect(DeciTreeOption<PayordarchInfo> option) {
		super(option, PayordarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PayordarchInfo>> getActionClassHook() {
		return StdPayordarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordarchInfo> mergeHook(List<PayordarchInfo> baseInfos, List<PayordarchInfo> selectedInfos) {	
		return PayordarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
