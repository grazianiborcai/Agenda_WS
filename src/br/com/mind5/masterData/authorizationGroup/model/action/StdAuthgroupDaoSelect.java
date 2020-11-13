package br.com.mind5.masterData.authorizationGroup.model.action;

import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAuthgroupDaoSelect extends ActionStdTemplate<AuthgroupInfo> {

	public StdAuthgroupDaoSelect(DeciTreeOption<AuthgroupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AuthgroupInfo> buildVisitorHook(DeciTreeOption<AuthgroupInfo> option) {
		return new VisiAuthgroupDaoSelect(option);
	}
}
