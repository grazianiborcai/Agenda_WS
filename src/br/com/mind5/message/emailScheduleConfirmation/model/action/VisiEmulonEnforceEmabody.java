package br.com.mind5.message.emailScheduleConfirmation.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonInfo;
import br.com.mind5.message.emailScheduleConfirmation.info.EmulonSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulonEnforceEmabody extends ActionVisitorTemplateEnforceV2<EmulonInfo> {
	
	public VisiEmulonEnforceEmabody(DeciTreeOption<EmulonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmulonInfo enforceHook(EmulonInfo recordInfo) {
		InfoSetter<EmulonInfo> attrSetter = new EmulonSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
