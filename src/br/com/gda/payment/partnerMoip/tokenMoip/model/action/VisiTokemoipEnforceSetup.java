package br.com.gda.payment.partnerMoip.tokenMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.gda.payment.partnerMoip.tokenMoip.info.TokemoipSetterSetup;

final class VisiTokemoipEnforceSetup extends ActionVisitorTemplateEnforce<TokemoipInfo> {
	
	@Override protected TokemoipInfo enforceHook(TokemoipInfo recordInfo) {
		InfoSetter<TokemoipInfo> attrSetter = new TokemoipSetterSetup();
		return attrSetter.setAttr(recordInfo);
	}
}
