package br.com.mind5.masterData.materialTypeSearch.model.action;

import br.com.mind5.masterData.materialTypeSearch.info.MatyparchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatyparchDaoSelect extends ActionStdTemplateV2<MatyparchInfo> {

	public StdMatyparchDaoSelect(DeciTreeOption<MatyparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatyparchInfo> buildVisitorHook(DeciTreeOption<MatyparchInfo> option) {
		return new VisiMatyparchDaoSelect(option);
	}
}
