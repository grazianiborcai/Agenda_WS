package br.com.mind5.masterData.timezone.model.action;

import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdTimezoneDaoSelect extends ActionStdTemplateV2<TimezoneInfo> {

	public StdTimezoneDaoSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<TimezoneInfo> buildVisitorHook(DeciTreeOption<TimezoneInfo> option) {
		return new VisiTimezoneDaoSelect(option);
	}
}
