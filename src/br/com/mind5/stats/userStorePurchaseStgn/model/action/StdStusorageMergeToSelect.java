package br.com.mind5.stats.userStorePurchaseStgn.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;

public final class StdStusorageMergeToSelect extends ActionStdTemplate<StusorageInfo> {

	public StdStusorageMergeToSelect(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorageInfo> buildVisitorHook(DeciTreeOption<StusorageInfo> option) {
		return new VisiStusorageMergeToSelect(option);
	}
}
