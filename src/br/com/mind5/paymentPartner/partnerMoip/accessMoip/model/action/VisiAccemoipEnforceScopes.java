package br.com.mind5.paymentPartner.partnerMoip.accessMoip.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.accessMoip.info.AccemoipSetterScopes;

final class VisiAccemoipEnforceScopes extends ActionVisitorTemplateEnforce<AccemoipInfo> {
	
	public VisiAccemoipEnforceScopes(DeciTreeOption<AccemoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected AccemoipInfo enforceHook(AccemoipInfo recordInfo) {
		InfoSetter<AccemoipInfo> attrSetter = new AccemoipSetterScopes();
		return attrSetter.setAttr(recordInfo);
	}
}
