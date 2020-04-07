package br.com.mind5.business.storeList.model.action;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdStolisMergeTimezone extends ActionStdTemplateV2<StolisInfo> {

	public StdStolisMergeTimezone(DeciTreeOption<StolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StolisInfo> buildVisitorHook(DeciTreeOption<StolisInfo> option) {
		return new VisiStolisMergeTimezone(option);
	}
}
