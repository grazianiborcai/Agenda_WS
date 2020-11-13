package br.com.mind5.business.scheduleDayData.model.action;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedaytaDaoSelect extends ActionStdTemplate<SchedaytaInfo> {

	public StdSchedaytaDaoSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedaytaInfo> buildVisitorHook(DeciTreeOption<SchedaytaInfo> option) {
		return new VisiSchedaytaDaoSelect(option);
	}
}
