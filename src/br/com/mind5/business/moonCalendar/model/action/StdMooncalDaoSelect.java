package br.com.mind5.business.moonCalendar.model.action;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalDaoSelect extends ActionStdTemplateV2<MooncalInfo> {
	
	public StdMooncalDaoSelect(DeciTreeOption<MooncalInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MooncalInfo> buildVisitorHook(DeciTreeOption<MooncalInfo> option) {
		return new VisiMooncalDaoSelect(option);
	}
}