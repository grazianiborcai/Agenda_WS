package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextEnforceLChanged extends ActionStdTemplate<MatextInfo> {

	public StdMatextEnforceLChanged(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatextInfo> buildVisitorHook(DeciTreeOption<MatextInfo> option) {
		return new VisiMatextEnforceLChanged(option);
	}
}
