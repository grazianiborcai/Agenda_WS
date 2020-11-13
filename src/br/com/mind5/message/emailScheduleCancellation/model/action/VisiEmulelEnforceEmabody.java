package br.com.mind5.message.emailScheduleCancellation.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelInfo;
import br.com.mind5.message.emailScheduleCancellation.info.EmulelSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmulelEnforceEmabody extends ActionVisitorTemplateEnforce<EmulelInfo> {
	
	public VisiEmulelEnforceEmabody(DeciTreeOption<EmulelInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmulelInfo enforceHook(EmulelInfo recordInfo) {
		InfoSetter<EmulelInfo> attrSetter = new EmulelSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
