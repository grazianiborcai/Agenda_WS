package br.com.mind5.business.materialTextDefault.model.action;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextaultMergeToSelect extends ActionStdTemplate<MatextaultInfo> {

	public StdMatextaultMergeToSelect(DeciTreeOption<MatextaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatextaultInfo> buildVisitorHook(DeciTreeOption<MatextaultInfo> option) {
		return new VisiMatextaultMergeToSelect(option);
	}
}
