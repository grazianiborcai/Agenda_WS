package br.com.mind5.masterData.currencySearch.model.action;

import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCurrarshDaoSelect extends ActionStdTemplate<CurrarshInfo> {

	public StdCurrarshDaoSelect(DeciTreeOption<CurrarshInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CurrarshInfo> buildVisitorHook(DeciTreeOption<CurrarshInfo> option) {
		return new VisiCurrarshDaoSelect(option);
	}
}
