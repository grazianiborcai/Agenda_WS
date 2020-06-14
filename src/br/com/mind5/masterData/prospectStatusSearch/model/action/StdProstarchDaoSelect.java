package br.com.mind5.masterData.prospectStatusSearch.model.action;

import br.com.mind5.masterData.prospectStatusSearch.info.ProstarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdProstarchDaoSelect extends ActionStdTemplateV2<ProstarchInfo> {

	public StdProstarchDaoSelect(DeciTreeOption<ProstarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<ProstarchInfo> buildVisitorHook(DeciTreeOption<ProstarchInfo> option) {
		return new VisiProstarchDaoSelect(option);
	}
}
