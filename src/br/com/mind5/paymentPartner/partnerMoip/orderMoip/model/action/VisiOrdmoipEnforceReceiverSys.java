package br.com.mind5.paymentPartner.partnerMoip.orderMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipSetterReceiverSys;

final class VisiOrdmoipEnforceReceiverSys extends ActionVisitorTemplateEnforceV2<OrdmoipInfo> {
	
	public VisiOrdmoipEnforceReceiverSys(DeciTreeOption<OrdmoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected OrdmoipInfo enforceHook(OrdmoipInfo recordInfo) {
		InfoSetter<OrdmoipInfo> setter = new OrdmoipSetterReceiverSys();
		return setter.setAttr(recordInfo);
	}
}
