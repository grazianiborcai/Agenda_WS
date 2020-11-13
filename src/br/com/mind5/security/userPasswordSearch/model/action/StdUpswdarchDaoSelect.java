package br.com.mind5.security.userPasswordSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPasswordSearch.info.UpswdarchInfo;

public final class StdUpswdarchDaoSelect extends ActionStdTemplate<UpswdarchInfo> {

	public StdUpswdarchDaoSelect(DeciTreeOption<UpswdarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UpswdarchInfo> buildVisitorHook(DeciTreeOption<UpswdarchInfo> option) {
		return new VisiUpswdarchDaoSelect(option);
	}
}
