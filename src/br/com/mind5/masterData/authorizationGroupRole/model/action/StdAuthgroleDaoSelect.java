package br.com.mind5.masterData.authorizationGroupRole.model.action;

import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdAuthgroleDaoSelect extends ActionStdTemplateV2<AuthgroleInfo> {

	public StdAuthgroleDaoSelect(DeciTreeOption<AuthgroleInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<AuthgroleInfo> buildVisitorHook(DeciTreeOption<AuthgroleInfo> option) {
		return new VisiAuthgroleDaoSelect(option);
	}
}
