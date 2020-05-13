package br.com.mind5.business.scheduleReserve.model.action;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchederveMergeToSelect extends ActionStdTemplateV2<SchederveInfo> {

	public StdSchederveMergeToSelect(DeciTreeOption<SchederveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<SchederveInfo> buildVisitorHook(DeciTreeOption<SchederveInfo> option) {
		return new VisiSchederveMergeToSelect(option);
	}
}
