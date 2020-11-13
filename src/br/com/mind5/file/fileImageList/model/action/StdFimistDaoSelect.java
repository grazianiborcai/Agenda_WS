package br.com.mind5.file.fileImageList.model.action;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimistDaoSelect extends ActionStdTemplate<FimistInfo> {

	public StdFimistDaoSelect(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimistInfo> buildVisitorHook(DeciTreeOption<FimistInfo> option) {
		return new VisiFimistDaoSelect(option);
	}
}
