package br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipSetterMultiorder;

final class VisiMultmoipEnforceMultiorder extends ActionVisitorTemplateEnforceV2<MultmoipInfo> {
	
	public VisiMultmoipEnforceMultiorder(DeciTreeOption<MultmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MultmoipInfo enforceHook(MultmoipInfo recordInfo) {
		InfoSetter<MultmoipInfo> setter = new MultmoipSetterMultiorder();
		return setter.setAttr(recordInfo);
	}
}
