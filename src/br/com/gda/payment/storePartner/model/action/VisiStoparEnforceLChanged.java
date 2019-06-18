package br.com.gda.payment.storePartner.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.info.StoparSetterLChanged;

final class VisiStoparEnforceLChanged extends ActionVisitorTemplateEnforce<StoparInfo> {
	
	@Override protected StoparInfo enforceHook(StoparInfo recordInfo) {
		InfoSetter<StoparInfo> attrSetter = new StoparSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
