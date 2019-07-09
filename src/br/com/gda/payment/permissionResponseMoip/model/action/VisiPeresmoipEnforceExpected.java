package br.com.gda.payment.permissionResponseMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionResponseMoip.info.PeresmoipSetterExpected;

final class VisiPeresmoipEnforceExpected extends ActionVisitorTemplateEnforce<PeresmoipInfo> {
	
	@Override protected PeresmoipInfo enforceHook(PeresmoipInfo recordInfo) {
		InfoSetter<PeresmoipInfo> attrSetter = new PeresmoipSetterExpected();
		return attrSetter.setAttr(recordInfo);
	}
}
