package br.com.gda.payment.accessMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.accessMoip.info.AccemoipSetterSetup;

final class VisiAccemoipEnforceSetup extends ActionVisitorTemplateEnforce<AccemoipInfo> {
	
	@Override protected AccemoipInfo enforceHook(AccemoipInfo recordInfo) {
		InfoSetter<AccemoipInfo> attrSetter = new AccemoipSetterSetup();
		return attrSetter.setAttr(recordInfo);
	}
}
