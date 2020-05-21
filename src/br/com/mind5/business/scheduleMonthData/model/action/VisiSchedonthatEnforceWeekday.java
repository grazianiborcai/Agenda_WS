package br.com.mind5.business.scheduleMonthData.model.action;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedonthatEnforceWeekday extends ActionVisitorTemplateEnforceV2<SchedonthatInfo> {
	
	public VisiSchedonthatEnforceWeekday(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedonthatInfo enforceHook(SchedonthatInfo recordInfo) {
		InfoSetter<SchedonthatInfo> attrSetter = new SchedonthatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
