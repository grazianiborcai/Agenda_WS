package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatMergeToUpdate extends ActionStdTemplate<MatInfo> {

	public StdMatMergeToUpdate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatInfo> buildVisitorHook(DeciTreeOption<MatInfo> option) {
		return new VisiMatMergeToUpdate(option);
	}
}
