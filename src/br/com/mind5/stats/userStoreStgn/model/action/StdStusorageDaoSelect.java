package br.com.mind5.stats.userStoreStgn.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;

public final class StdStusorageDaoSelect extends ActionStdTemplate<StusorageInfo> {

	public StdStusorageDaoSelect(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorageInfo> buildVisitorHook(DeciTreeOption<StusorageInfo> option) {
		return new VisiStusorageDaoSelect(option);
	}
}
