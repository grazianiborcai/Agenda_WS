package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipSetterSetup;

public final class TokemoipVisiEnforceSetup extends ActionVisitorTemplateEnforce<TokemoipInfo> {
	
	public TokemoipVisiEnforceSetup(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected TokemoipInfo enforceHook(TokemoipInfo recordInfo) {
		InfoSetter<TokemoipInfo> attrSetter = new TokemoipSetterSetup();
		return attrSetter.setAttr(recordInfo);
	}
}
