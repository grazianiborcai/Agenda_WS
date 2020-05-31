package br.com.mind5.business.calendarMoon.model.action;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalMergeToSelect extends ActionStdTemplateV2<MooncalInfo> {
	
	public StdMooncalMergeToSelect(DeciTreeOption<MooncalInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MooncalInfo> buildVisitorHook(DeciTreeOption<MooncalInfo> option) {
		return new VisiMooncalMergeToSelect(option);
	}
}
