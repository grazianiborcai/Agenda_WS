package br.com.mind5.stats.statsUserStore.userStore.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStore.info.StusoreInfo;

public class StdStusoreSuccess extends ActionStdSuccessTemplate<StusoreInfo> {
	
	public StdStusoreSuccess(DeciTreeOption<StusoreInfo> option) {
		super(option);
	}
}
