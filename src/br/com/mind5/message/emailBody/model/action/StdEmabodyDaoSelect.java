package br.com.mind5.message.emailBody.model.action;

import br.com.mind5.message.emailBody.info.EmabodyInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmabodyDaoSelect extends ActionStdTemplate<EmabodyInfo> {

	public StdEmabodyDaoSelect(DeciTreeOption<EmabodyInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmabodyInfo> buildVisitorHook(DeciTreeOption<EmabodyInfo> option) {
		return new VisiEmabodyDaoSelect(option);
	}
}
