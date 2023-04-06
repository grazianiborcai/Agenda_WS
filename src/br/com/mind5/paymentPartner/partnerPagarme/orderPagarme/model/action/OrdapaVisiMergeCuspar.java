package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaMerger;

public final class OrdapaVisiMergeCuspar extends ActionVisitorTemplateMerge<OrdapaInfo, CusparInfo> {
	
	public OrdapaVisiMergeCuspar(DeciTreeOption<OrdapaInfo> option) {
		super(option, CusparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootSelect.class;
	}
	
	
	
	@Override protected List<OrdapaInfo> mergeHook(List<OrdapaInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return OrdapaMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
