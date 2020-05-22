package br.com.mind5.masterData.movimentType.model.action;

import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMamovypeDaoSelect extends ActionStdTemplateV2<MamovypeInfo> {

	public StdMamovypeDaoSelect(DeciTreeOption<MamovypeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MamovypeInfo> buildVisitorHook(DeciTreeOption<MamovypeInfo> option) {
		return new VisiMamovypeDaoSelect(option);
	}
}
