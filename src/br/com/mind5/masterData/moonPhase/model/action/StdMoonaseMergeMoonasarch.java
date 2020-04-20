package br.com.mind5.masterData.moonPhase.model.action;

import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonaseMergeMoonasarch extends ActionStdTemplateV2<MoonaseInfo> {

	public StdMoonaseMergeMoonasarch(DeciTreeOption<MoonaseInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MoonaseInfo> buildVisitorHook(DeciTreeOption<MoonaseInfo> option) {
		return new VisiMoonaseMergeMoonasarch(option);
	}
}
