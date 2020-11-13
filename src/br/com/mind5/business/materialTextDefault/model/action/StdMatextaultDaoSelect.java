package br.com.mind5.business.materialTextDefault.model.action;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultDaoSelect extends ActionStdTemplate<MatextaultInfo> {

	public StdMatextaultDaoSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatextaultInfo> buildVisitorHook(DeciTreeOption<MatextaultInfo> option) {
		return new VisiMatextaultDaoSelect(option);
	}
}
