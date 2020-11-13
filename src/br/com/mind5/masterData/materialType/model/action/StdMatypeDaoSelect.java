package br.com.mind5.masterData.materialType.model.action;

import br.com.mind5.masterData.materialType.info.MatypeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatypeDaoSelect extends ActionStdTemplate<MatypeInfo> {

	public StdMatypeDaoSelect(DeciTreeOption<MatypeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatypeInfo> buildVisitorHook(DeciTreeOption<MatypeInfo> option) {
		return new VisiMatypeDaoSelect(option);
	}
}
