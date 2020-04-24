package br.com.mind5.masterData.dayParting.model.action;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDaypartDaoSelect extends ActionStdTemplateV2<DaypartInfo> {

	public StdDaypartDaoSelect(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<DaypartInfo> buildVisitorHook(DeciTreeOption<DaypartInfo> option) {
		return new VisiDaypartDaoSelect(option);
	}
}
