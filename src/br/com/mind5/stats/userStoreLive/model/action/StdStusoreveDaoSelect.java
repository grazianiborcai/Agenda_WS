package br.com.mind5.stats.userStoreLive.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.userStoreLive.info.StusoreveInfo;

public final class StdStusoreveDaoSelect extends ActionStdTemplate<StusoreveInfo> {

	public StdStusoreveDaoSelect(DeciTreeOption<StusoreveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StusoreveInfo> buildVisitorHook(DeciTreeOption<StusoreveInfo> option) {
		return new VisiStusoreveDaoSelect(option);
	}
}
