package br.com.mind5.masterData.materialCategorySearch.model.action;

import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMategarchDaoSelect extends ActionStdTemplateV2<MategarchInfo> {

	public StdMategarchDaoSelect(DeciTreeOption<MategarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MategarchInfo> buildVisitorHook(DeciTreeOption<MategarchInfo> option) {
		return new VisiMategarchDaoSelect(option);
	}
}
