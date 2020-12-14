package br.com.mind5.stats.userStore.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStore.info.StusoreInfo;

public final class StdStusoreMergeStusoreve extends ActionStdTemplate<StusoreInfo> {

	public StdStusoreMergeStusoreve(DeciTreeOption<StusoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoreInfo> buildVisitorHook(DeciTreeOption<StusoreInfo> option) {
		return new VisiStusoreMergeStusoreve(option);
	}
}
