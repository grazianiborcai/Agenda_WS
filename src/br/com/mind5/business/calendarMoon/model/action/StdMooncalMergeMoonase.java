package br.com.mind5.business.calendarMoon.model.action;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMooncalMergeMoonase extends ActionStdTemplate<MooncalInfo> {
	
	public StdMooncalMergeMoonase(DeciTreeOption<MooncalInfo> option) {			
		super(option);
	}
	
	
	
	protected ActionVisitor<MooncalInfo> buildVisitorHook(DeciTreeOption<MooncalInfo> option) {
		return new VisiMooncalMergeMoonase(option);
	}
}
