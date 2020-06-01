package br.com.mind5.business.calendarTimeStore.model.action;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCalimoreMergeCalate extends ActionStdTemplateV2<CalimoreInfo> {

	public StdCalimoreMergeCalate(DeciTreeOption<CalimoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CalimoreInfo> buildVisitorHook(DeciTreeOption<CalimoreInfo> option) {
		return new VisiCalimoreMergeCalate(option);
	}
}
