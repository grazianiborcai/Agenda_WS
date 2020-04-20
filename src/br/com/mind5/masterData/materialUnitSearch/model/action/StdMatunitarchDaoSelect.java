package br.com.mind5.masterData.materialUnitSearch.model.action;

import br.com.mind5.masterData.materialUnitSearch.info.MatunitarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatunitarchDaoSelect extends ActionStdTemplateV2<MatunitarchInfo> {

	public StdMatunitarchDaoSelect(DeciTreeOption<MatunitarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatunitarchInfo> buildVisitorHook(DeciTreeOption<MatunitarchInfo> option) {
		return new VisiMatunitarchDaoSelect(option);
	}
}
