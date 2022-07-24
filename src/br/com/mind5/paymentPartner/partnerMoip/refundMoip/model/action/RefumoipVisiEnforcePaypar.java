package br.com.mind5.paymentPartner.partnerMoip.refundMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.refundMoip.info.RefumoipSetterPaypar;

public final class RefumoipVisiEnforcePaypar extends ActionVisitorTemplateEnforce<RefumoipInfo> {
	
	public RefumoipVisiEnforcePaypar(DeciTreeOption<RefumoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected RefumoipInfo enforceHook(RefumoipInfo recordInfo) {
		InfoSetter<RefumoipInfo> setter = new RefumoipSetterPaypar();
		return setter.setAttr(recordInfo);
	}
}
