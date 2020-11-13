package br.com.mind5.masterData.movimentType.model.action;

import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMamovypeDaoSelect extends ActionStdTemplate<MamovypeInfo> {

	public StdMamovypeDaoSelect(DeciTreeOption<MamovypeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MamovypeInfo> buildVisitorHook(DeciTreeOption<MamovypeInfo> option) {
		return new VisiMamovypeDaoSelect(option);
	}
}
