package br.com.mind5.business.scheduleWeekData.model.action;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedeekdatMergeToSelect extends ActionStdTemplateV2<SchedeekdatInfo> {

	public StdSchedeekdatMergeToSelect(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedeekdatInfo> buildVisitorHook(DeciTreeOption<SchedeekdatInfo> option) {
		return new VisiSchedeekdatMergeToSelect(option);
	}
}
