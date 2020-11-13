package br.com.mind5.masterData.materialUnit.model.action;

import br.com.mind5.masterData.materialUnit.info.MatunitInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatunitDaoSelect extends ActionStdTemplate<MatunitInfo> {

	public StdMatunitDaoSelect(DeciTreeOption<MatunitInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatunitInfo> buildVisitorHook(DeciTreeOption<MatunitInfo> option) {
		return new VisiMatunitDaoSelect(option);
	}
}
