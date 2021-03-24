package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgysEnforceCreatedOn extends ActionStdTemplate<FimgysInfo> {

	public StdFimgysEnforceCreatedOn(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgysInfo> buildVisitorHook(DeciTreeOption<FimgysInfo> option) {
		return new VisiFimgysEnforceCreatedOn(option);
	}
}
