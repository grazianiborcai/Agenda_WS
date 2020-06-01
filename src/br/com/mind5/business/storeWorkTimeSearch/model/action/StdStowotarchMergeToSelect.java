package br.com.mind5.business.storeWorkTimeSearch.model.action;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotarchMergeToSelect extends ActionStdTemplateV2<StowotarchInfo> {

	public StdStowotarchMergeToSelect(DeciTreeOption<StowotarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StowotarchInfo> buildVisitorHook(DeciTreeOption<StowotarchInfo> option) {
		return new VisiStowotarchMergeToSelect(option);
	}
}
