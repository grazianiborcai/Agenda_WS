package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info.CustopaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.model.decisionTree.CustopaRootCreate;

public final class CustopaVisiRootCreate extends ActionVisitorTemplateAction<CustopaInfo, CustopaInfo> {

	public CustopaVisiRootCreate(DeciTreeOption<CustopaInfo> option) {
		super(option, CustopaInfo.class, CustopaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CustopaInfo>> getTreeClassHook() {
		return CustopaRootCreate.class;
	}
	
	
	
	@Override protected List<CustopaInfo> toBaseClassHook(List<CustopaInfo> baseInfos, List<CustopaInfo> results) {
		return results;
	}
}
