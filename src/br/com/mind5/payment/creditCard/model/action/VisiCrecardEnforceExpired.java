package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardSetterExpired;

final class VisiCrecardEnforceExpired extends ActionVisitorTemplateEnforceV2<CrecardInfo> {
	
	public VisiCrecardEnforceExpired(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CrecardInfo enforceHook(CrecardInfo recordInfo) {
		InfoSetter<CrecardInfo> attrSetter = new CrecardSetterExpired();
		return attrSetter.setAttr(recordInfo);
	}
}
