package br.com.mind5.message.emailPasswordChange.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.message.emailPasswordChange.info.EmordeSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmordeEnforceEmabody extends ActionVisitorTemplateEnforceV2<EmordeInfo> {
	
	public VisiEmordeEnforceEmabody(DeciTreeOption<EmordeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmordeInfo enforceHook(EmordeInfo recordInfo) {
		InfoSetter<EmordeInfo> attrSetter = new EmordeSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
