package br.com.mind5.business.materialMovementSearch.model.action;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmarchMergeToSelect extends ActionStdTemplate<MatmarchInfo> {

	public StdMatmarchMergeToSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatmarchInfo> buildVisitorHook(DeciTreeOption<MatmarchInfo> option) {
		return new VisiMatmarchMergeToSelect(option);
	}
}
