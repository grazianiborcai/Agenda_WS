package br.com.mind5.business.scheduleDayData.model.action;

import br.com.mind5.business.scheduleDayData.info.SchedaytaInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedaytaMergeToSelect extends ActionStdTemplateV2<SchedaytaInfo> {

	public StdSchedaytaMergeToSelect(DeciTreeOption<SchedaytaInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchedaytaInfo> buildVisitorHook(DeciTreeOption<SchedaytaInfo> option) {
		return new VisiSchedaytaMergeToSelect(option);
	}
}
