package br.com.gda.business.phoneSnapshot.model.action;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPhonapSuccess extends ActionStdSuccessTemplate<PhonapInfo> {

	public StdPhonapSuccess(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
}
