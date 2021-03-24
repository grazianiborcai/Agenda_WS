package br.com.mind5.file.sysFileImageSnapshot.model.action;

import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgysapDaoInsert extends ActionStdTemplate<FimgysapInfo> {

	public StdFimgysapDaoInsert(DeciTreeOption<FimgysapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgysapInfo> buildVisitorHook(DeciTreeOption<FimgysapInfo> option) {
		return new VisiFimgysapDaoInsert(option);
	}
}
