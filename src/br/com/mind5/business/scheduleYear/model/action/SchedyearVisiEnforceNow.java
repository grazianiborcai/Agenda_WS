package br.com.mind5.business.scheduleYear.model.action;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearSetterNow;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearVisiEnforceNow extends ActionVisitorTemplateEnforce<SchedyearInfo> {
	
	public SchedyearVisiEnforceNow(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}

	
	
	@Override protected SchedyearInfo enforceHook(SchedyearInfo recordInfo) {
		InfoSetter<SchedyearInfo> attrSetter = new SchedyearSetterNow();
		return attrSetter.setAttr(recordInfo);
	}
}
