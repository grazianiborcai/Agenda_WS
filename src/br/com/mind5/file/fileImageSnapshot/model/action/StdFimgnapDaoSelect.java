package br.com.mind5.file.fileImageSnapshot.model.action;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgnapDaoSelect extends ActionStdTemplate<FimgnapInfo> {

	public StdFimgnapDaoSelect(DeciTreeOption<FimgnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgnapInfo> buildVisitorHook(DeciTreeOption<FimgnapInfo> option) {
		return new VisiFimgnapDaoSelect(option);
	}
}
