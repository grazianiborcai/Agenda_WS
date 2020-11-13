package br.com.mind5.business.materialStockSearch.model.action;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatocarchMergeToSelect extends ActionStdTemplate<MatocarchInfo> {

	public StdMatocarchMergeToSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatocarchInfo> buildVisitorHook(DeciTreeOption<MatocarchInfo> option) {
		return new VisiMatocarchMergeToSelect(option);
	}
}
