package br.com.mind5.business.scheduleWeekData.model.action;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatSetterWeekday;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedeekdatEnforceWeekday extends ActionVisitorTemplateEnforce<SchedeekdatInfo> {
	
	public VisiSchedeekdatEnforceWeekday(DeciTreeOption<SchedeekdatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedeekdatInfo enforceHook(SchedeekdatInfo recordInfo) {
		InfoSetter<SchedeekdatInfo> attrSetter = new SchedeekdatSetterWeekday();
		return attrSetter.setAttr(recordInfo);
	}
}
