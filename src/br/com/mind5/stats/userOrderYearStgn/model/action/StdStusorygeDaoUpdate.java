package br.com.mind5.stats.userOrderYearStgn.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;

public final class StdStusorygeDaoUpdate extends ActionStdTemplate<StusorygeInfo> {

	public StdStusorygeDaoUpdate(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorygeInfo> buildVisitorHook(DeciTreeOption<StusorygeInfo> option) {
		return new VisiStusorygeDaoUpdate(option);
	}
}
