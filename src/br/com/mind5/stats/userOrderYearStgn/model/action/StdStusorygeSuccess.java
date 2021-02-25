package br.com.mind5.stats.userOrderYearStgn.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;

public class StdStusorygeSuccess extends ActionStdSuccessTemplate<StusorygeInfo> {
	
	public StdStusorygeSuccess(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
}
