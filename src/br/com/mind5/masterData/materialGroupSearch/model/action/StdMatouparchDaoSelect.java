package br.com.mind5.masterData.materialGroupSearch.model.action;

import br.com.mind5.masterData.materialGroupSearch.info.MatouparchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatouparchDaoSelect extends ActionStdTemplateV2<MatouparchInfo> {

	public StdMatouparchDaoSelect(DeciTreeOption<MatouparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatouparchInfo> buildVisitorHook(DeciTreeOption<MatouparchInfo> option) {
		return new VisiMatouparchDaoSelect(option);
	}
}
