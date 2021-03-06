package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgn.info.StusorygeInfo;

public final class StdStusorygeMergeToSelect extends ActionStdTemplate<StusorygeInfo> {

	public StdStusorygeMergeToSelect(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygeInfo> buildVisitorHook(DeciTreeOption<StusorygeInfo> option) {
		return new VisiStusorygeMergeToSelect(option);
	}
}
