package br.com.mind5.businessContent.material.main.model.action;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcinSuccess extends ActionStdSuccessTemplate<MatbcinInfo> {
	
	public StdMatbcinSuccess(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
}
