package br.com.gda.payment.accessMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.accessMoip.info.AccemoipInfo;
import br.com.gda.payment.accessMoip.info.AccemoipSetterObfuscate;

final class VisiAccemoipEnforceObfuscate extends ActionVisitorTemplateEnforce<AccemoipInfo> {
	
	@Override protected AccemoipInfo enforceHook(AccemoipInfo recordInfo) {
		InfoSetter<AccemoipInfo> attrSetter = new AccemoipSetterObfuscate();
		return attrSetter.setAttr(recordInfo);
	}
}
