package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardSetterKey;

final class VisiCrecardEnforceKey extends ActionVisitorTemplateEnforce<CrecardInfo> {
	
	@Override protected CrecardInfo enforceHook(CrecardInfo recordInfo) {
		InfoSetter<CrecardInfo> attrSetter = new CrecardSetterKey();
		return attrSetter.setAttr(recordInfo);
	}
}
