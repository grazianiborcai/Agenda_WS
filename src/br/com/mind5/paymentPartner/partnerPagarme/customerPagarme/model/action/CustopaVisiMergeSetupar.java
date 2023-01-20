package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.payment.setupPartner.model.decisionTree.SetuparRootSelect;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaMerger;

public final class CustopaVisiMergeSetupar extends ActionVisitorTemplateMerge<CustopaInfo, SetuparInfo> {
	
	public CustopaVisiMergeSetupar(DeciTreeOption<CustopaInfo> option) {
		super(option, SetuparInfo.class); 
	}
	
	
	
	@Override protected Class<? extends DeciTree<SetuparInfo>> getTreeClassHook() {
		return SetuparRootSelect.class;
	}
	
	
	
	@Override protected List<CustopaInfo> mergeHook(List<CustopaInfo> baseInfos, List<SetuparInfo> selectedInfos) {	
		return CustopaMerger.mergeWithSetupar(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
