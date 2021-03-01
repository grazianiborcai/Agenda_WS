package br.com.mind5.stats.statsUserStore.userStore.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStore.info.StusoreInfo;

public final class StdStusoreMergeStusoragg extends ActionStdTemplate<StusoreInfo> {

	public StdStusoreMergeStusoragg(DeciTreeOption<StusoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoreInfo> buildVisitorHook(DeciTreeOption<StusoreInfo> option) {
		return new VisiStusoreMergeStusoragg(option);
	}
}
