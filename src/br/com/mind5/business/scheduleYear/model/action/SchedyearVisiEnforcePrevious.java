package br.com.mind5.business.scheduleYear.model.action;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearSetterPrevious;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearVisiEnforcePrevious extends ActionVisitorTemplateEnforce<SchedyearInfo> {
	
	public SchedyearVisiEnforcePrevious(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}

	
	
	@Override protected SchedyearInfo enforceHook(SchedyearInfo recordInfo) {
		InfoSetter<SchedyearInfo> attrSetter = new SchedyearSetterPrevious();
		return attrSetter.setAttr(recordInfo);
	}
}
