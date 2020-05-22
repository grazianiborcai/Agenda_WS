package br.com.mind5.masterData.userCategory.model.action;

import br.com.mind5.masterData.userCategory.info.UseregInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdUseregDaoSelect extends ActionStdTemplateV2<UseregInfo> {

	public StdUseregDaoSelect(DeciTreeOption<UseregInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UseregInfo> buildVisitorHook(DeciTreeOption<UseregInfo> option) {
		return new VisiUseregDaoSelect(option);
	}
}
