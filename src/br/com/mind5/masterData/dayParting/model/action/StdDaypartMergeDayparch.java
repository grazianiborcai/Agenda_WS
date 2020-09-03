package br.com.mind5.masterData.dayParting.model.action;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDaypartMergeDayparch extends ActionStdTemplateV2<DaypartInfo> {

	public StdDaypartMergeDayparch(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<DaypartInfo> buildVisitorHook(DeciTreeOption<DaypartInfo> option) {
		return new VisiDaypartMergeDayparch(option);
	}
}
