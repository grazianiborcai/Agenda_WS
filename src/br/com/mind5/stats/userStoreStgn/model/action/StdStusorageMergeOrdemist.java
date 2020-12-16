package br.com.mind5.stats.userStoreStgn.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreStgn.info.StusorageInfo;

public final class StdStusorageMergeOrdemist extends ActionStdTemplate<StusorageInfo> {

	public StdStusorageMergeOrdemist(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusorageInfo> buildVisitorHook(DeciTreeOption<StusorageInfo> option) {
		return new VisiStusorageMergeOrdemist(option);
	}
}
