package br.com.mind5.masterData.dayPartingSearch.model.action;

import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDayparchDaoSelect extends ActionStdTemplate<DayparchInfo> {

	public StdDayparchDaoSelect(DeciTreeOption<DayparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DayparchInfo> buildVisitorHook(DeciTreeOption<DayparchInfo> option) {
		return new VisiDayparchDaoSelect(option);
	}
}
