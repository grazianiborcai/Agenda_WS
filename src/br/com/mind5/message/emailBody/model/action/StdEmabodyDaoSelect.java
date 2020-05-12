package br.com.mind5.message.emailBody.model.action;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmabodyDaoSelect extends ActionStdTemplateV2<EmabodyInfo> {

	public StdEmabodyDaoSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmabodyInfo> buildVisitorHook(DeciTreeOption<EmabodyInfo> option) {
		return new VisiEmabodyDaoSelect(option);
	}
}
