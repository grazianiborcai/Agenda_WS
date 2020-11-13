package br.com.mind5.masterData.moonPhaseSearch.model.action;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonasarchDaoSelect extends ActionStdTemplate<MoonasarchInfo> {

	public StdMoonasarchDaoSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MoonasarchInfo> buildVisitorHook(DeciTreeOption<MoonasarchInfo> option) {
		return new VisiMoonasarchDaoSelect(option);
	}
}
