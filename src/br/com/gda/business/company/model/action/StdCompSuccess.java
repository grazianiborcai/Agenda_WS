package br.com.gda.business.company.model.action;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdCompSuccess extends ActionStdSuccessTemplate<CompInfo> {
	public StdCompSuccess(DeciTreeOption<CompInfo> option) {
		super(option);
	}
}
