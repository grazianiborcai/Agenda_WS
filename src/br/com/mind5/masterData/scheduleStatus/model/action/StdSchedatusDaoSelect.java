package br.com.mind5.masterData.scheduleStatus.model.action;

import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedatusDaoSelect extends ActionStdTemplate<SchedatusInfo> {

	public StdSchedatusDaoSelect(DeciTreeOption<SchedatusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedatusInfo> buildVisitorHook(DeciTreeOption<SchedatusInfo> option) {
		return new VisiSchedatusDaoSelect(option);
	}
}
