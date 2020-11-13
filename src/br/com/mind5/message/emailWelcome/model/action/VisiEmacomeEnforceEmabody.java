package br.com.mind5.message.emailWelcome.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailWelcome.info.EmacomeInfo;
import br.com.mind5.message.emailWelcome.info.EmacomeSetterEmabody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforce;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmacomeEnforceEmabody extends ActionVisitorTemplateEnforce<EmacomeInfo> {
	
	public VisiEmacomeEnforceEmabody(DeciTreeOption<EmacomeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmacomeInfo enforceHook(EmacomeInfo recordInfo) {
		InfoSetter<EmacomeInfo> attrSetter = new EmacomeSetterEmabody();
		return attrSetter.setAttr(recordInfo);
	}
}
