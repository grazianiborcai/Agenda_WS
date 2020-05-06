package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

final class VisiPayordMergeToUpdate extends ActionVisitorTemplateMergeV2<PayordInfo, PayordInfo> {
	
	public VisiPayordMergeToUpdate(DeciTreeOption<PayordInfo> option) {
		super(option, PayordInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<PayordInfo>> getActionClassHook() {
		return StdPayordDaoSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<PayordInfo> selectedInfos) {	
		return PayordMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
