package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;

public final class StdAccemoipPeresmoipInsert extends ActionStdTemplateV2<AccemoipInfo> {

	public StdAccemoipPeresmoipInsert(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AccemoipInfo> buildVisitorHook(DeciTreeOption<AccemoipInfo> option) {
		return new VisiAccemoipPeresmoipInsert(option);
	}
}