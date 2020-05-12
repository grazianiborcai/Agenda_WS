package br.com.mind5.message.emailBody.model.action;

import br.com.mind5.info.InfoSetter;
import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.message.emailBody.info.EmabodySetterBody;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmabodyEnforceBody extends ActionVisitorTemplateEnforceV2<EmabodyInfo> {
	
	public VisiEmabodyEnforceBody(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	@Override protected EmabodyInfo enforceHook(EmabodyInfo recordInfo) {
		InfoSetter<EmabodyInfo> attrSetter = new EmabodySetterBody();
		return attrSetter.setAttr(recordInfo);
	}
}
