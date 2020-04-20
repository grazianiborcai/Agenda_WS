package br.com.mind5.masterData.currencySearch.model.action;

import br.com.mind5.masterData.currencySearch.info.CurrarshInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCurrarshDaoSelect extends ActionStdTemplateV2<CurrarshInfo> {

	public StdCurrarshDaoSelect(DeciTreeOption<CurrarshInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CurrarshInfo> buildVisitorHook(DeciTreeOption<CurrarshInfo> option) {
		return new VisiCurrarshDaoSelect(option);
	}
}
