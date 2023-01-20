package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.decisionTree.CustopaNodeSetuparL2;

public final class CustopaVisiNodeSetuparL2 extends ActionVisitorTemplateAction<CustopaInfo, CustopaInfo> {

	public CustopaVisiNodeSetuparL2(DeciTreeOption<CustopaInfo> option) {
		super(option, CustopaInfo.class, CustopaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustopaInfo>> getTreeClassHook() {
		return CustopaNodeSetuparL2.class;
	}
	
	
	
	@Override protected List<CustopaInfo> toBaseClassHook(List<CustopaInfo> baseInfos, List<CustopaInfo> results) {
		return results;
	}
}
