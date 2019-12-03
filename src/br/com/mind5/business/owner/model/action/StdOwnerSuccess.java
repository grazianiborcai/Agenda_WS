package br.com.mind5.business.owner.model.action;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerSuccess extends ActionStdSuccessTemplate<OwnerInfo> {
	public StdOwnerSuccess(DeciTreeOption<OwnerInfo> option) {
		super(option);
	}
}
