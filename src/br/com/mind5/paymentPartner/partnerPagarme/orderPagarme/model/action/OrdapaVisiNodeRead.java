package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.decisionTree.OrdapaNodeRead;

public final class OrdapaVisiNodeRead extends ActionVisitorTemplateAction<OrdapaInfo, OrdapaInfo> {

	public OrdapaVisiNodeRead(DeciTreeOption<OrdapaInfo> option) {
		super(option, OrdapaInfo.class, OrdapaInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdapaInfo>> getTreeClassHook() {
		return OrdapaNodeRead.class;
	}
	
	
	
	@Override protected List<OrdapaInfo> toBaseClassHook(List<OrdapaInfo> baseInfos, List<OrdapaInfo> results) {
		return results;
	}
}
