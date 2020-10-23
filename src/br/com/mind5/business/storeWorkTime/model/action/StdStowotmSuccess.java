package br.com.mind5.business.storeWorkTime.model.action;

import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStowotmSuccess extends ActionStdSuccessTemplate<StowotmInfo> {
	
	public StdStowotmSuccess(DeciTreeOption<StowotmInfo> option) {
		super(option);
	}
}
