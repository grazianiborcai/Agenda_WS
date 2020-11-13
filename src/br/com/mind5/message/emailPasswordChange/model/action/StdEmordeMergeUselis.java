package br.com.mind5.message.emailPasswordChange.model.action;

import br.com.mind5.message.emailPasswordChange.info.EmordeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmordeMergeUselis extends ActionStdTemplate<EmordeInfo> {

	public StdEmordeMergeUselis(DeciTreeOption<EmordeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmordeInfo> buildVisitorHook(DeciTreeOption<EmordeInfo> option) {
		return new VisiEmordeMergeUselis(option);
	}
}
