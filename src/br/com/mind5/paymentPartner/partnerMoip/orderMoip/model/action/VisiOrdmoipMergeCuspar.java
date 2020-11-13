package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparCopier;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.RootCusparSelect;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipMerger;

final class VisiOrdmoipMergeCuspar extends ActionVisitorTemplateMerge<OrdmoipInfo, CusparInfo> {
	
	public VisiOrdmoipMergeCuspar(DeciTreeOption<OrdmoipInfo> option) {
		super(option, CusparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return RootCusparSelect.class;
	}
	
	
	
	@Override protected List<CusparInfo> toActionClassHook(List<OrdmoipInfo> recordInfos) {
		return CusparCopier.copyFromOrdmoip(recordInfos);
	}
	
	
	
	@Override protected List<OrdmoipInfo> mergeHook(List<OrdmoipInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return OrdmoipMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
