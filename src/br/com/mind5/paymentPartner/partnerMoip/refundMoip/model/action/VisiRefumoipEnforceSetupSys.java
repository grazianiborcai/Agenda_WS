package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipSetterSetupSys;

final class VisiRefumoipEnforceSetupSys extends ActionVisitorTemplateEnforce<RefumoipInfo> {
	
	public VisiRefumoipEnforceSetupSys(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected RefumoipInfo enforceHook(RefumoipInfo recordInfo) {
		InfoSetter<RefumoipInfo> setter = new RefumoipSetterSetupSys();
		return setter.setAttr(recordInfo);
	}
}
