package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.decisionTree.OrdapaNodeSetuparL2;

public final class OrdapaVisiNodeSetuparL2 extends ActionVisitorTemplateAction<OrdapaInfo, OrdapaInfo> {

	public OrdapaVisiNodeSetuparL2(DeciTreeOption<OrdapaInfo> option) {
		super(option, OrdapaInfo.class, OrdapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdapaInfo>> getTreeClassHook() {
		return OrdapaNodeSetuparL2.class;
	}
	
	
	
	@Override protected List<OrdapaInfo> toBaseClassHook(List<OrdapaInfo> baseInfos, List<OrdapaInfo> results) {
		return results;
	}
}
