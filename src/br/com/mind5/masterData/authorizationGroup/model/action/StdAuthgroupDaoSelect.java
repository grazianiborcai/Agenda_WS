package br.com.mind5.masterData.authorizationGroup.model.action;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAuthgroupDaoSelect extends ActionStdTemplateV2<AuthgroupInfo> {

	public StdAuthgroupDaoSelect(DeciTreeOption<AuthgroupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AuthgroupInfo> buildVisitorHook(DeciTreeOption<AuthgroupInfo> option) {
		return new VisiAuthgroupDaoSelect(option);
	}
}
