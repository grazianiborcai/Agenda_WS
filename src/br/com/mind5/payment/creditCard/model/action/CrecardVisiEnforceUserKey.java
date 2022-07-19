package br.com.mind5.payment.creditCard.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.creditCard.info.CrecardSetterUserKey;

public final class CrecardVisiEnforceUserKey extends ActionVisitorTemplateEnforce<CrecardInfo> {
	
	public CrecardVisiEnforceUserKey(DeciTreeOption<CrecardInfo> option) {
		super(option);
	}
	
	
	
	@Override protected CrecardInfo enforceHook(CrecardInfo recordInfo) {
		InfoSetter<CrecardInfo> attrSetter = new CrecardSetterUserKey();
		return attrSetter.setAttr(recordInfo);
	}
}
