package br.com.mind5.payment.payOrderList.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.payOrderList.info.PayordistMerger;

final class VisiPayordistMergeToSelect extends ActionVisitorTemplateMergeV2<PayordistInfo, PayordistInfo> {
	
	public VisiPayordistMergeToSelect(DeciTreeOption<PayordistInfo> option) {
		super(option, PayordistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PayordistInfo>> getActionClassHook() {
		return StdPayordistDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordistInfo> mergeHook(List<PayordistInfo> baseInfos, List<PayordistInfo> selectedInfos) {	
		return PayordistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
