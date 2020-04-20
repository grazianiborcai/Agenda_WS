package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimarchEnforceCus extends ActionStdTemplateV2<FimarchInfo> {

	public StdFimarchEnforceCus(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<FimarchInfo> buildVisitorHook(DeciTreeOption<FimarchInfo> option) {
		return new VisiFimarchEnforceCus(option);
	}
}
