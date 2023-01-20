package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.masterData.paymentPartnerDefault.model.decisionTree.PayparultRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;

public final class CusparVisiMergePayparult extends ActionVisitorTemplateMerge<CusparInfo, PayparultInfo> {
	
	public CusparVisiMergePayparult(DeciTreeOption<CusparInfo> option) {
		super(option, PayparultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparultInfo>> getTreeClassHook() {
		return PayparultRootSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> mergeHook(List<CusparInfo> baseInfos, List<PayparultInfo> selectedInfos) {	
		return CusparMerger.mergeWithPayparult(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
