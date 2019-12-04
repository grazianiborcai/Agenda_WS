package br.com.mind5.business.materialText.model.action;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextSuccess extends ActionStdSuccessTemplate<MatextInfo> {
	public StdMatextSuccess(DeciTreeOption<MatextInfo> option) {
		super(option);
	}
}
