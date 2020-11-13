package br.com.mind5.masterData.userCategory.model.action;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdUseregDaoSelect extends ActionStdTemplate<UseregInfo> {

	public StdUseregDaoSelect(DeciTreeOption<UseregInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UseregInfo> buildVisitorHook(DeciTreeOption<UseregInfo> option) {
		return new VisiUseregDaoSelect(option);
	}
}
