package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.info.PersolisSetterRestricted;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersolisEnforceRestricted extends ActionVisitorTemplateEnforceV2<PersolisInfo> {
	
	public VisiPersolisEnforceRestricted(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	

	@Override protected PersolisInfo enforceHook(PersolisInfo recordInfo) {
		InfoSetter<PersolisInfo> attrSetter = new PersolisSetterRestricted();
		return attrSetter.setAttr(recordInfo);
	}
}
