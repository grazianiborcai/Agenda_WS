package br.com.mind5.masterData.fileDocTypeSearch.model.action;

import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFidocarchDaoSelect extends ActionStdTemplate<FidocarchInfo> {

	public StdFidocarchDaoSelect(DeciTreeOption<FidocarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FidocarchInfo> buildVisitorHook(DeciTreeOption<FidocarchInfo> option) {
		return new VisiFidocarchDaoSelect(option);
	}
}
