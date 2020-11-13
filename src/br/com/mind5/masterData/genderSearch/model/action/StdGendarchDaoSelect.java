package br.com.mind5.masterData.genderSearch.model.action;

import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGendarchDaoSelect extends ActionStdTemplate<GendarchInfo> {

	public StdGendarchDaoSelect(DeciTreeOption<GendarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<GendarchInfo> buildVisitorHook(DeciTreeOption<GendarchInfo> option) {
		return new VisiGendarchDaoSelect(option);
	}
}
