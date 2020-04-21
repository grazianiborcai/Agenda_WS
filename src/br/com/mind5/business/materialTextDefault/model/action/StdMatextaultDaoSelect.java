package br.com.mind5.business.materialTextDefault.model.action;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultDaoSelect extends ActionStdTemplateV2<MatextaultInfo> {

	public StdMatextaultDaoSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatextaultInfo> buildVisitorHook(DeciTreeOption<MatextaultInfo> option) {
		return new VisiMatextaultDaoSelect(option);
	}
}
