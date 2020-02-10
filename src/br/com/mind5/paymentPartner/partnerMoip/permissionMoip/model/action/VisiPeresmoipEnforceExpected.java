package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipSetterExpected;

final class VisiPeresmoipEnforceExpected extends ActionVisitorTemplateEnforce<PeresmoipInfo> {
	
	@Override protected PeresmoipInfo enforceHook(PeresmoipInfo recordInfo) {
		InfoSetter<PeresmoipInfo> attrSetter = new PeresmoipSetterExpected();
		return attrSetter.setAttr(recordInfo);
	}
}
