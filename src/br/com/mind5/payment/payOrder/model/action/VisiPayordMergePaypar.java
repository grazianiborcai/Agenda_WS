package br.com.mind5.payment.payOrder.model.action;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrder.info.PayordMerger;

final class VisiPayordMergePaypar extends ActionVisitorTemplateMergeV2<PayordInfo, PayparInfo> {
	
	public VisiPayordMergePaypar(DeciTreeOption<PayordInfo> option) {
		super(option, PayparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> baseInfos, List<PayparInfo> selectedInfos) {	
		return PayordMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
