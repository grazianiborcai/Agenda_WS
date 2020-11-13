package br.com.mind5.masterData.dayParting.model.action;

import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDaypartDaoSelect extends ActionStdTemplate<DaypartInfo> {

	public StdDaypartDaoSelect(DeciTreeOption<DaypartInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DaypartInfo> buildVisitorHook(DeciTreeOption<DaypartInfo> option) {
		return new VisiDaypartDaoSelect(option);
	}
}
