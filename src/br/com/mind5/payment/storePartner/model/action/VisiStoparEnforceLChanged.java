package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparSetterLChanged;

final class VisiStoparEnforceLChanged extends ActionVisitorTemplateEnforce<StoparInfo> {
	
	@Override protected StoparInfo enforceHook(StoparInfo recordInfo) {
		InfoSetter<StoparInfo> attrSetter = new StoparSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
