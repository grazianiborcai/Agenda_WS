package br.com.mind5.business.storeTextDefault.model.action;

import br.com.mind5.business.storeTextDefault.info.StorextaultInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextaultDaoSelect extends ActionStdTemplateV2<StorextaultInfo> {

	public StdStorextaultDaoSelect(DeciTreeOption<StorextaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorextaultInfo> buildVisitorHook(DeciTreeOption<StorextaultInfo> option) {
		return new VisiStorextaultDaoSelect(option);
	}
}
