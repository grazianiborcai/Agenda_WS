package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineSetterCreatedBy;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiSchedineEnforceCreatedBy extends ActionVisitorTemplateEnforceV2<SchedineInfo> {
	
	public VisiSchedineEnforceCreatedBy(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
	
	
	
	@Override protected SchedineInfo enforceHook(SchedineInfo recordInfo) {
		InfoSetter<SchedineInfo> setter = new SchedineSetterCreatedBy();
		return setter.setAttr(recordInfo);
	}
}
