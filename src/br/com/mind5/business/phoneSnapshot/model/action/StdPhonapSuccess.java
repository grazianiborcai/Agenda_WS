package br.com.mind5.business.phoneSnapshot.model.action;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonapSuccess extends ActionStdSuccessTemplate<PhonapInfo> {

	public StdPhonapSuccess(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
}
