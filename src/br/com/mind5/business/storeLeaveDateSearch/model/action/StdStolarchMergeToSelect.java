package br.com.mind5.business.storeLeaveDateSearch.model.action;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolarchMergeToSelect extends ActionStdTemplateV2<StolarchInfo> {

	public StdStolarchMergeToSelect(DeciTreeOption<StolarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StolarchInfo> buildVisitorHook(DeciTreeOption<StolarchInfo> option) {
		return new VisiStolarchMergeToSelect(option);
	}
}
