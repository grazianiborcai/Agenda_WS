package br.com.mind5.business.materialList.model.action;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatlisMergeMatarch extends ActionStdTemplate<MatlisInfo> {

	public StdMatlisMergeMatarch(DeciTreeOption<MatlisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatlisInfo> buildVisitorHook(DeciTreeOption<MatlisInfo> option) {
		return new VisiMatlisMergeMatarch(option);
	}
}
