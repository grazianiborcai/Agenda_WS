package br.com.mind5.file.fileImageSnapshot.model.action;

import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgnapDaoInsert extends ActionStdTemplate<FimgnapInfo> {

	public StdFimgnapDaoInsert(DeciTreeOption<FimgnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgnapInfo> buildVisitorHook(DeciTreeOption<FimgnapInfo> option) {
		return new VisiFimgnapDaoInsert(option);
	}
}
