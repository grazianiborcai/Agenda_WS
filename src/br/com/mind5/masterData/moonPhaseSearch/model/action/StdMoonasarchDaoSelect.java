package br.com.mind5.masterData.moonPhaseSearch.model.action;

import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMoonasarchDaoSelect extends ActionStdTemplateV2<MoonasarchInfo> {

	public StdMoonasarchDaoSelect(DeciTreeOption<MoonasarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MoonasarchInfo> buildVisitorHook(DeciTreeOption<MoonasarchInfo> option) {
		return new VisiMoonasarchDaoSelect(option);
	}
}
