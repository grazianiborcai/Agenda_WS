package br.com.mind5.business.storeLeaveDateRange.model.action;

import br.com.mind5.business.storeLeaveDateRange.info.StolargInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolargMergeToSelect extends ActionStdTemplateV2<StolargInfo> {

	public StdStolargMergeToSelect(DeciTreeOption<StolargInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StolargInfo> buildVisitorHook(DeciTreeOption<StolargInfo> option) {
		return new VisiStolargMergeToSelect(option);
	}
}
