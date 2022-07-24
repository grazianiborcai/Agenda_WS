package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipSetterPaypar;

public final class PeresmoipVisiEnforcePaypar extends ActionVisitorTemplateEnforce<PeresmoipInfo> {
	
	public PeresmoipVisiEnforcePaypar(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PeresmoipInfo enforceHook(PeresmoipInfo recordInfo) {
		InfoSetter<PeresmoipInfo> attrSetter = new PeresmoipSetterPaypar();
		return attrSetter.setAttr(recordInfo);
	}
}
