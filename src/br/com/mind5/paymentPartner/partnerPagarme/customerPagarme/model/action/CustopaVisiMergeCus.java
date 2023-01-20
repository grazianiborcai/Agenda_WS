package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.decisionTree.CusRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaMerger;

public final class CustopaVisiMergeCus extends ActionVisitorTemplateMerge<CustopaInfo, CusInfo> {
	
	public CustopaVisiMergeCus(DeciTreeOption<CustopaInfo> option) {
		super(option, CusInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return CusRootSelect.class;
	}
	
	
	
	@Override protected List<CustopaInfo> mergeHook(List<CustopaInfo> baseInfos, List<CusInfo> selectedInfos) {	
		return CustopaMerger.mergeWithCus(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
