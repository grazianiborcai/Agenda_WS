package br.com.mind5.masterData.moonPhase.model.action;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonaseMergeMoonasarch extends ActionStdTemplate<MoonaseInfo> {

	public StdMoonaseMergeMoonasarch(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MoonaseInfo> buildVisitorHook(DeciTreeOption<MoonaseInfo> option) {
		return new VisiMoonaseMergeMoonasarch(option);
	}
}
