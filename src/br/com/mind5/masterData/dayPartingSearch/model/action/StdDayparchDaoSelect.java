package br.com.mind5.masterData.dayPartingSearch.model.action;

import br.com.mind5.masterData.dayPartingSearch.info.DayparchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDayparchDaoSelect extends ActionStdTemplateV2<DayparchInfo> {

	public StdDayparchDaoSelect(DeciTreeOption<DayparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<DayparchInfo> buildVisitorHook(DeciTreeOption<DayparchInfo> option) {
		return new VisiDayparchDaoSelect(option);
	}
}
