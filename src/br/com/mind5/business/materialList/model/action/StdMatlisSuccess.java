package br.com.mind5.business.materialList.model.action;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatlisSuccess extends ActionStdSuccessTemplate<MatlisInfo> {
	
	public StdMatlisSuccess(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
}
