package br.com.mind5.stats.statsUserStore.userStoreStgn.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;

public class StdStusorageSuccess extends ActionStdSuccessTemplate<StusorageInfo> {
	
	public StdStusorageSuccess(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
}
