package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipSetterResponseOrdmoip;

final class VisiMultmoipEnforceResponseOrdmoip extends ActionVisitorTemplateEnforce<MultmoipInfo> {
	
	public VisiMultmoipEnforceResponseOrdmoip(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MultmoipInfo enforceHook(MultmoipInfo recordInfo) {
		InfoSetter<MultmoipInfo> setter = new MultmoipSetterResponseOrdmoip();
		return setter.setAttr(recordInfo);
	}
}
