package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchSuccess extends ActionStdSuccessTemplate<PerarchInfo> {
	
	public StdPerarchSuccess(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
}
