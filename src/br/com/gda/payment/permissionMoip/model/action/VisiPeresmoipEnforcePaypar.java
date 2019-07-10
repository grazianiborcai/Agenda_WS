package br.com.gda.payment.permissionMoip.model.action;

import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;
import br.com.gda.payment.permissionMoip.info.PeresmoipInfo;
import br.com.gda.payment.permissionMoip.info.PeresmoipSetterPaypar;

final class VisiPeresmoipEnforcePaypar extends ActionVisitorTemplateEnforce<PeresmoipInfo> {
	
	@Override protected PeresmoipInfo enforceHook(PeresmoipInfo recordInfo) {
		InfoSetter<PeresmoipInfo> attrSetter = new PeresmoipSetterPaypar();
		return attrSetter.setAttr(recordInfo);
	}
}
