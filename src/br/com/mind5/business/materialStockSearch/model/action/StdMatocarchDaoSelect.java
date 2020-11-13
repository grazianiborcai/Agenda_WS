package br.com.mind5.business.materialStockSearch.model.action;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatocarchDaoSelect extends ActionStdTemplateV2<MatocarchInfo> {

	public StdMatocarchDaoSelect(DeciTreeOption<MatocarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatocarchInfo> buildVisitorHook(DeciTreeOption<MatocarchInfo> option) {
		return new VisiMatocarchDaoSelect(option);
	}
}
