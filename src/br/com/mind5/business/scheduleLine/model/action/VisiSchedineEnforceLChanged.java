package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineSetterLChanged;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineEnforceLChanged extends ActionVisitorTemplateEnforce<SchedineInfo> {
	
	public VisiSchedineEnforceLChanged(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedineInfo enforceHook(SchedineInfo recordInfo) {
		InfoSetter<SchedineInfo> setter = new SchedineSetterLChanged();
		return setter.setAttr(recordInfo);
	}
}
