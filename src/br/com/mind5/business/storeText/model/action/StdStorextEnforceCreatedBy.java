package br.com.mind5.business.storeText.model.action;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextEnforceCreatedBy extends ActionStdTemplateV2<StorextInfo> {

	public StdStorextEnforceCreatedBy(DeciTreeOption<StorextInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorextInfo> buildVisitorHook(DeciTreeOption<StorextInfo> option) {
		return new VisiStorextEnforceCreatedBy(option);
	}
}