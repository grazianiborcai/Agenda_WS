package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatEnforceCreatedBy extends ActionStdTemplateV2<MatInfo> {

	public StdMatEnforceCreatedBy(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatInfo> buildVisitorHook(DeciTreeOption<MatInfo> option) {
		return new VisiMatEnforceCreatedBy(option);
	}
}
