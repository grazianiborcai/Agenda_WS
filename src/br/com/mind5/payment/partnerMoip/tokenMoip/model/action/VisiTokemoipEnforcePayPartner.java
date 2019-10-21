package br.com.mind5.payment.partnerMoip.tokenMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipInfo;
import br.com.mind5.payment.partnerMoip.tokenMoip.info.TokemoipSetterCodPayPartner;

final class VisiTokemoipEnforcePayPartner extends ActionVisitorTemplateEnforce<TokemoipInfo> {
	
	@Override protected TokemoipInfo enforceHook(TokemoipInfo recordInfo) {
		InfoSetter<TokemoipInfo> attrSetter = new TokemoipSetterCodPayPartner();
		return attrSetter.setAttr(recordInfo);
	}
}
