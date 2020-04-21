package br.com.mind5.business.materialTextDefault.model.action;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultMergeToSelect extends ActionStdTemplateV2<MatextaultInfo> {

	public StdMatextaultMergeToSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatextaultInfo> buildVisitorHook(DeciTreeOption<MatextaultInfo> option) {
		return new VisiMatextaultMergeToSelect(option);
	}
}
