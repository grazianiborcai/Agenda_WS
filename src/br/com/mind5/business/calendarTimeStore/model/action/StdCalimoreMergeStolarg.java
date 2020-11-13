package br.com.mind5.business.calendarTimeStore.model.action;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalimoreMergeStolarg extends ActionStdTemplate<CalimoreInfo> {

	public StdCalimoreMergeStolarg(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CalimoreInfo> buildVisitorHook(DeciTreeOption<CalimoreInfo> option) {
		return new VisiCalimoreMergeStolarg(option);
	}
}
