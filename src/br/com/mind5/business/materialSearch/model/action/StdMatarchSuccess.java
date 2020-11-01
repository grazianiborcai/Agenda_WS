package br.com.mind5.business.materialSearch.model.action;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatarchSuccess extends ActionStdSuccessTemplate<MatarchInfo> {
	
	public StdMatarchSuccess(DeciTreeOption<MatarchInfo> option) {
		super(option);
	}
}
