package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparSetterDel;

final class VisiStoparEnforceDel extends ActionVisitorTemplateEnforce<StoparInfo> {
	
	@Override protected StoparInfo enforceHook(StoparInfo recordInfo) {
		InfoSetter<StoparInfo> attrSetter = new StoparSetterDel();
		return attrSetter.setAttr(recordInfo);
	}
}
