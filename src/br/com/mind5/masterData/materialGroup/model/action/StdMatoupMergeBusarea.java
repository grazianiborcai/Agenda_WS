package br.com.mind5.masterData.materialGroup.model.action;

import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoupMergeBusarea extends ActionStdTemplate<MatoupInfo> {

	public StdMatoupMergeBusarea(DeciTreeOption<MatoupInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatoupInfo> buildVisitorHook(DeciTreeOption<MatoupInfo> option) {
		return new VisiMatoupMergeBusarea(option);
	}
}
