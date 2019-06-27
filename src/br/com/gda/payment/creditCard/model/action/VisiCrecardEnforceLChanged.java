package br.com.gda.payment.creditCard.model.action;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.info.CrecardSetterLChanged;
import br.com.gda.info.InfoSetter;
import br.com.gda.model.action.ActionVisitorTemplateEnforce;

final class VisiCrecardEnforceLChanged extends ActionVisitorTemplateEnforce<CrecardInfo> {
	
	@Override protected CrecardInfo enforceHook(CrecardInfo recordInfo) {
		InfoSetter<CrecardInfo> attrSetter = new CrecardSetterLChanged();
		return attrSetter.setAttr(recordInfo);
	}
}
