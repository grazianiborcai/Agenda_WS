package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;

public final class StdTokemoipMergeSyspar extends ActionStdTemplate<TokemoipInfo> {

	public StdTokemoipMergeSyspar(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<TokemoipInfo> buildVisitorHook(DeciTreeOption<TokemoipInfo> option) {
		return new VisiTokemoipMergeSyspar(option);
	}
}
