package br.com.mind5.payment.partnerMoip.accessMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.payment.partnerMoip.accessMoip.info.AccemoipSetterCodPayPartner;

final class VisiAccemoipEnforcePayPartner extends ActionVisitorTemplateEnforce<AccemoipInfo> {
	
	@Override protected AccemoipInfo enforceHook(AccemoipInfo recordInfo) {
		InfoSetter<AccemoipInfo> attrSetter = new AccemoipSetterCodPayPartner();
		return attrSetter.setAttr(recordInfo);
	}
}
