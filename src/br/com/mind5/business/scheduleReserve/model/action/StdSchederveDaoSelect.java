package br.com.mind5.business.scheduleReserve.model.action;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchederveDaoSelect extends ActionStdTemplate<SchederveInfo> {

	public StdSchederveDaoSelect(DeciTreeOption<SchederveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchederveInfo> buildVisitorHook(DeciTreeOption<SchederveInfo> option) {
		return new VisiSchederveDaoSelect(option);
	}
}
