package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipSetterLChanged;

public final class PeresmoipVisiEnforceLChanged extends ActionVisitorTemplateEnforce<PeresmoipInfo> {
	
	public PeresmoipVisiEnforceLChanged(DeciTreeOption<PeresmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected PeresmoipInfo enforceHook(PeresmoipInfo recordInfo) {
		InfoSetter<PeresmoipInfo> attrSetter = new PeresmoipSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
