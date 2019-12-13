package br.com.mind5.business.materialStock.model.action;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatockSuccess extends ActionStdSuccessTemplate<MatockInfo> {
	public StdMatockSuccess(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
}
