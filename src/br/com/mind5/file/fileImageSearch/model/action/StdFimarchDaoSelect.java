package br.com.mind5.file.fileImageSearch.model.action;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimarchDaoSelect extends ActionStdTemplate<FimarchInfo> {

	public StdFimarchDaoSelect(DeciTreeOption<FimarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimarchInfo> buildVisitorHook(DeciTreeOption<FimarchInfo> option) {
		return new VisiFimarchDaoSelect(option);
	}
}
