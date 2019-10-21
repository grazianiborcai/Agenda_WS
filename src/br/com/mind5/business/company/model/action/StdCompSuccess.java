package br.com.mind5.business.company.model.action;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCompSuccess extends ActionStdSuccessTemplate<CompInfo> {
	public StdCompSuccess(DeciTreeOption<CompInfo> option) {
		super(option);
	}
}
