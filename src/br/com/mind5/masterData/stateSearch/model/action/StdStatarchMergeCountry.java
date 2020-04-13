package br.com.mind5.masterData.stateSearch.model.action;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStatarchMergeCountry extends ActionStdTemplateV2<StatarchInfo> {

	public StdStatarchMergeCountry(DeciTreeOption<StatarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StatarchInfo> buildVisitorHook(DeciTreeOption<StatarchInfo> option) {
		return new VisiStatarchMergeCountry(option);
	}
}
