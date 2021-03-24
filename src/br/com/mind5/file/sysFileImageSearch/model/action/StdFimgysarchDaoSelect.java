package br.com.mind5.file.sysFileImageSearch.model.action;

import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgysarchDaoSelect extends ActionStdTemplate<FimgysarchInfo> {

	public StdFimgysarchDaoSelect(DeciTreeOption<FimgysarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgysarchInfo> buildVisitorHook(DeciTreeOption<FimgysarchInfo> option) {
		return new VisiFimgysarchDaoSelect(option);
	}
}
