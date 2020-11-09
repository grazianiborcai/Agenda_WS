package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipSetterCodPayPartner;

final class VisiAccemoipEnforcePayPartner extends ActionVisitorTemplateEnforceV2<AccemoipInfo> {
	
	public VisiAccemoipEnforcePayPartner(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected AccemoipInfo enforceHook(AccemoipInfo recordInfo) {
		InfoSetter<AccemoipInfo> attrSetter = new AccemoipSetterCodPayPartner();
		return attrSetter.setAttr(recordInfo);
	}
}
