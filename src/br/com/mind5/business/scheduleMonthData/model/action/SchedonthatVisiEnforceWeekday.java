package br.com.mind5.business.scheduleMonthData.model.action;

import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedonthatVisiEnforceWeekday extends ActionVisitorTemplateEnforce<SchedonthatInfo> {
	
	public SchedonthatVisiEnforceWeekday(DeciTreeOption<SchedonthatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedonthatInfo enforceHook(SchedonthatInfo recordInfo) {
		InfoSetter<SchedonthatInfo> attrSetter = new SchedonthatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
