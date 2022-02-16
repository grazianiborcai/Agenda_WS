package br.com.mind5.stats.statsStoreDashboard.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;

public final class StdStorashSuccess extends ActionStdSuccessTemplate<StorashInfo> {
	public StdStorashSuccess(DeciTreeOption<StorashInfo> option) {
		super(option);
	}
}
