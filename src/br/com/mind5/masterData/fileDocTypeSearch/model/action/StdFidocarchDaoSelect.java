package br.com.mind5.masterData.fileDocTypeSearch.model.action;

import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFidocarchDaoSelect extends ActionStdTemplateV2<FidocarchInfo> {

	public StdFidocarchDaoSelect(DeciTreeOption<FidocarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FidocarchInfo> buildVisitorHook(DeciTreeOption<FidocarchInfo> option) {
		return new VisiFidocarchDaoSelect(option);
	}
}
