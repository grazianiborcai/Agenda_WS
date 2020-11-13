package br.com.mind5.business.scheduleDayData.model.action;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedaytaMergeToSelect extends ActionStdTemplate<SchedaytaInfo> {

	public StdSchedaytaMergeToSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedaytaInfo> buildVisitorHook(DeciTreeOption<SchedaytaInfo> option) {
		return new VisiSchedaytaMergeToSelect(option);
	}
}
