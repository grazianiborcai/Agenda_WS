package br.com.mind5.businessContent.material.main.model.action;

import br.com.mind5.businessContent.material.main.info.MatbcinInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcinMergeOwnelis extends ActionStdTemplate<MatbcinInfo> {

	public StdMatbcinMergeOwnelis(DeciTreeOption<MatbcinInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatbcinInfo> buildVisitorHook(DeciTreeOption<MatbcinInfo> option) {
		return new VisiMatbcinMergeOwnelis(option);
	}
}
