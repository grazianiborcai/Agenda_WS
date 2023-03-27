package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.decisionTree.CusparRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaMerger;

public final class CustopaVisiMergeCuspar extends ActionVisitorTemplateMerge<CustopaInfo, CusparInfo> {
	
	public CustopaVisiMergeCuspar(DeciTreeOption<CustopaInfo> option) {
		super(option, CusparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return CusparRootSelect.class;
	}
	
	
	
	@Override protected List<CustopaInfo> mergeHook(List<CustopaInfo> baseInfos, List<CusparInfo> selectedInfos) {	
		return CustopaMerger.mergeWithCuspar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
