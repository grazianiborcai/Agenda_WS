package br.com.mind5.business.material.model.action;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatSuccess extends ActionStdSuccessTemplate<MatInfo> {
	
	public StdMatSuccess(DeciTreeOption<MatInfo> option) {
		super(option);
	}
}
