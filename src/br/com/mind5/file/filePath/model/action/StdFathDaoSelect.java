package br.com.mind5.file.filePath.model.action;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFathDaoSelect extends ActionStdTemplate<FathInfo> {

	public StdFathDaoSelect(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FathInfo> buildVisitorHook(DeciTreeOption<FathInfo> option) {
		return new VisiFathDaoSelect(option);
	}
}
