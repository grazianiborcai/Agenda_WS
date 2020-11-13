package br.com.mind5.masterData.materialUnitSearch.model.action;

import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatunitarchDaoSelect extends ActionStdTemplate<MatunitarchInfo> {

	public StdMatunitarchDaoSelect(DeciTreeOption<MatunitarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatunitarchInfo> buildVisitorHook(DeciTreeOption<MatunitarchInfo> option) {
		return new VisiMatunitarchDaoSelect(option);
	}
}
