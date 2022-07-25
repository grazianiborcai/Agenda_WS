package br.com.mind5.payment.storePartnerList.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.masterData.paymentPartner.model.decisionTree.PayparRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;
import br.com.mind5.payment.storePartnerList.info.StoplisMerger;

public final class StoplisVisiMergePaypar extends ActionVisitorTemplateMerge<StoplisInfo, PayparInfo> {
	
	public StoplisVisiMergePaypar(DeciTreeOption<StoplisInfo> option) {
		super(option, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return PayparRootSelect.class;
	}
	
	
	
	@Override protected List<StoplisInfo> mergeHook(List<StoplisInfo> baseInfos, List<PayparInfo> selectedInfos) {	
		return StoplisMerger.mergeWithPaypar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
