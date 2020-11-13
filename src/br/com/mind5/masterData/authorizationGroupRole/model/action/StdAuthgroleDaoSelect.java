package br.com.mind5.masterData.authorizationGroupRole.model.action;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAuthgroleDaoSelect extends ActionStdTemplate<AuthgroleInfo> {

	public StdAuthgroleDaoSelect(DeciTreeOption<AuthgroleInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<AuthgroleInfo> buildVisitorHook(DeciTreeOption<AuthgroleInfo> option) {
		return new VisiAuthgroleDaoSelect(option);
	}
}
