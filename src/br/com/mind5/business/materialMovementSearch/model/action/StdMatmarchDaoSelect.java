package br.com.mind5.business.materialMovementSearch.model.action;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatmarchDaoSelect extends ActionStdTemplate<MatmarchInfo> {

	public StdMatmarchDaoSelect(DeciTreeOption<MatmarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatmarchInfo> buildVisitorHook(DeciTreeOption<MatmarchInfo> option) {
		return new VisiMatmarchDaoSelect(option);
	}
}
