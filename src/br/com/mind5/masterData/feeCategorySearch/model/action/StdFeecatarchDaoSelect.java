package br.com.mind5.masterData.feeCategorySearch.model.action;

import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeecatarchDaoSelect extends ActionStdTemplateV2<FeecatarchInfo> {

	public StdFeecatarchDaoSelect(DeciTreeOption<FeecatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FeecatarchInfo> buildVisitorHook(DeciTreeOption<FeecatarchInfo> option) {
		return new VisiFeecatarchDaoSelect(option);
	}
}
