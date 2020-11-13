package br.com.mind5.masterData.materialCategorySearch.model.action;

import br.com.mind5.masterData.materialCategorySearch.info.MategarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMategarchDaoSelect extends ActionStdTemplate<MategarchInfo> {

	public StdMategarchDaoSelect(DeciTreeOption<MategarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MategarchInfo> buildVisitorHook(DeciTreeOption<MategarchInfo> option) {
		return new VisiMategarchDaoSelect(option);
	}
}
