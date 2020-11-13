package br.com.mind5.security.userPassword.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class StdUpswdMergeUselis extends ActionStdTemplate<UpswdInfo> {

	public StdUpswdMergeUselis(DeciTreeOption<UpswdInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<UpswdInfo> buildVisitorHook(DeciTreeOption<UpswdInfo> option) {
		return new VisiUpswdMergeUselis(option);
	}
}
