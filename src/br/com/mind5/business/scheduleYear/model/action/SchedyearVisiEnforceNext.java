package br.com.mind5.business.scheduleYear.model.action;

import br.com.mind5.business.scheduleYear.info.SchedyearInfo;
import br.com.mind5.business.scheduleYear.info.SchedyearSetterNext;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedyearVisiEnforceNext extends ActionVisitorTemplateEnforce<SchedyearInfo> {
	
	public SchedyearVisiEnforceNext(DeciTreeOption<SchedyearInfo> option) {
		super(option);
	}

	
	
	@Override protected SchedyearInfo enforceHook(SchedyearInfo recordInfo) {
		InfoSetter<SchedyearInfo> attrSetter = new SchedyearSetterNext();
		return attrSetter.setAttr(recordInfo);
	}
}
