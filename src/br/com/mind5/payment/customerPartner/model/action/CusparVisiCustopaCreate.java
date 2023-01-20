package br.com.mind5.payment.customerPartner.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.info.CusparMerger;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.decisionTree.CustopaRootCreateFromCus;

public final class CusparVisiCustopaCreate extends ActionVisitorTemplateAction<CusparInfo, CustopaInfo> {
	public CusparVisiCustopaCreate(DeciTreeOption<CusparInfo> option) {
		super(option, CusparInfo.class, CustopaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustopaInfo>> getTreeClassHook() {
		return CustopaRootCreateFromCus.class;
	}
	
	
	
	@Override protected List<CusparInfo> toBaseClassHook(List<CusparInfo> baseInfos, List<CustopaInfo> results) {
		return CusparMerger.mergeWithCustopa(baseInfos, results);
	}
}
