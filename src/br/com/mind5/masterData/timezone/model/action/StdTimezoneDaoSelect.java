package br.com.mind5.masterData.timezone.model.action;

import br.com.mind5.masterData.timezone.info.TimezoneInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdTimezoneDaoSelect extends ActionStdTemplate<TimezoneInfo> {

	public StdTimezoneDaoSelect(DeciTreeOption<TimezoneInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<TimezoneInfo> buildVisitorHook(DeciTreeOption<TimezoneInfo> option) {
		return new VisiTimezoneDaoSelect(option);
	}
}
