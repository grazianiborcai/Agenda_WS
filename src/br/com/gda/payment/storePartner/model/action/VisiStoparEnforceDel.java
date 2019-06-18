package br.com.gda.payment.storePartner.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.storePartner.info.StoparInfo;
import br.com.gda.payment.storePartner.info.StoparSetterDel;

final class VisiStoparEnforceDel extends ActionVisitorTemplateEnforce<StoparInfo> {
	
	@Override protected StoparInfo enforceHook(StoparInfo recordInfo) {
		InfoSetter<StoparInfo> attrSetter = new StoparSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
