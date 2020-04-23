package br.com.mind5.masterData.genderSearch.model.action;

import br.com.mind5.masterData.genderSearch.info.GendarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdGendarchDaoSelect extends ActionStdTemplateV2<GendarchInfo> {

	public StdGendarchDaoSelect(DeciTreeOption<GendarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<GendarchInfo> buildVisitorHook(DeciTreeOption<GendarchInfo> option) {
		return new VisiGendarchDaoSelect(option);
	}
}
