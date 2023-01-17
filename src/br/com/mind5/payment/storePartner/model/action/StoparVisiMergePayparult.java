package br.com.mind5.payment.storePartner.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.masterData.paymentPartnerDefault.model.decisionTree.PayparultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;

public final class StoparVisiMergePayparult extends ActionVisitorTemplateMerge<StoparInfo, PayparultInfo> {
	
	public StoparVisiMergePayparult(DeciTreeOption<StoparInfo> option) {
		super(option, PayparultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparultInfo>> getTreeClassHook() {
		return PayparultRootSelect.class;
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> baseInfos, List<PayparultInfo> selectedInfos) {	
		return StoparMerger.mergeWithPayparult(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
