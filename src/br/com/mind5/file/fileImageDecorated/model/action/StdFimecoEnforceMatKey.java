package br.com.mind5.file.fileImageDecorated.model.action;

import br.com.mind5.file.fileImageDecorated.info.FimecoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimecoEnforceMatKey extends ActionStdTemplate<FimecoInfo> {

	public StdFimecoEnforceMatKey(DeciTreeOption<FimecoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimecoInfo> buildVisitorHook(DeciTreeOption<FimecoInfo> option) {
		return new VisiFimecoEnforceMatKey(option);
	}
}
