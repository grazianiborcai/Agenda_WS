package br.com.mind5.payment.partnerMoip.accessMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipSetterObfuscate;

final class VisiAccemoipEnforceObfuscate extends ActionVisitorTemplateEnforce<AccemoipInfo> {
	
	@Override protected AccemoipInfo enforceHook(AccemoipInfo recordInfo) {
		InfoSetter<AccemoipInfo> attrSetter = new AccemoipSetterObfuscate();
		return attrSetter.setAttr(recordInfo);
	}
}
