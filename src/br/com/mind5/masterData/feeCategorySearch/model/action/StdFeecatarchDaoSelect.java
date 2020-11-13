package br.com.mind5.masterData.feeCategorySearch.model.action;

import br.com.mind5.masterData.feeCategorySearch.info.FeecatarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFeecatarchDaoSelect extends ActionStdTemplate<FeecatarchInfo> {

	public StdFeecatarchDaoSelect(DeciTreeOption<FeecatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FeecatarchInfo> buildVisitorHook(DeciTreeOption<FeecatarchInfo> option) {
		return new VisiFeecatarchDaoSelect(option);
	}
}
