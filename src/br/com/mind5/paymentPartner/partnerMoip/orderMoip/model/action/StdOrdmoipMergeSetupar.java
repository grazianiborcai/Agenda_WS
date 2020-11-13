package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

public final class StdOrdmoipMergeSetupar extends ActionStdTemplate<OrdmoipInfo> {

	public StdOrdmoipMergeSetupar(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdmoipInfo> buildVisitorHook(DeciTreeOption<OrdmoipInfo> option) {
		return new VisiOrdmoipMergeSetupar(option);
	}
}
