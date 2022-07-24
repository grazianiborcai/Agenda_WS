package br.com.mind5.paymentPartner.partnerMoip.tokenMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.tokenMoip.info.TokemoipSetterCodPayPartner;

public final class TokemoipVisiEnforcePayPartner extends ActionVisitorTemplateEnforce<TokemoipInfo> {
	
	public TokemoipVisiEnforcePayPartner(DeciTreeOption<TokemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected TokemoipInfo enforceHook(TokemoipInfo recordInfo) {
		InfoSetter<TokemoipInfo> attrSetter = new TokemoipSetterCodPayPartner();
		return attrSetter.setAttr(recordInfo);
	}
}
