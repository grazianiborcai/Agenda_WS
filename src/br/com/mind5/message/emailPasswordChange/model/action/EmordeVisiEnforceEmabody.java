package br.com.mind5.message.emailPasswordChange.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.message.emailPasswordChange.info.EmordeSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmordeVisiEnforceEmabody extends ActionVisitorTemplateEnforce<EmordeInfo> {
	
	public EmordeVisiEnforceEmabody(DeciTreeOption<EmordeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmordeInfo enforceHook(EmordeInfo recordInfo) {
		InfoSetter<EmordeInfo> attrSetter = new EmordeSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
