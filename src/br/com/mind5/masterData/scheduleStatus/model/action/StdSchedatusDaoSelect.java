package br.com.mind5.masterData.scheduleStatus.model.action;

import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedatusDaoSelect extends ActionStdTemplateV2<SchedatusInfo> {

	public StdSchedatusDaoSelect(DeciTreeOption<SchedatusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedatusInfo> buildVisitorHook(DeciTreeOption<SchedatusInfo> option) {
		return new VisiSchedatusDaoSelect(option);
	}
}
