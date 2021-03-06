package br.com.mind5.stats.statsUserStore.userStoreLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;

public final class StdStusoreveMergeCurrency extends ActionStdTemplate<StusoreveInfo> {

	public StdStusoreveMergeCurrency(DeciTreeOption<StusoreveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoreveInfo> buildVisitorHook(DeciTreeOption<StusoreveInfo> option) {
		return new VisiStusoreveMergeCurrency(option);
	}
}
