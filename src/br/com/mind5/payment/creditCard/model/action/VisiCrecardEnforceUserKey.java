package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardSetterUserKey;

final class VisiCrecardEnforceUserKey extends ActionVisitorTemplateEnforce<CrecardInfo> {
	
	public VisiCrecardEnforceUserKey(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CrecardInfo enforceHook(CrecardInfo recordInfo) {
		InfoSetter<CrecardInfo> attrSetter = new CrecardSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
