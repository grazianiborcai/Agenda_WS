package br.com.mind5.business.calendarTimeStore.model.action;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalimoreMergeCalate extends ActionStdTemplate<CalimoreInfo> {

	public StdCalimoreMergeCalate(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalimoreInfo> buildVisitorHook(DeciTreeOption<CalimoreInfo> option) {
		return new VisiCalimoreMergeCalate(option);
	}
}
