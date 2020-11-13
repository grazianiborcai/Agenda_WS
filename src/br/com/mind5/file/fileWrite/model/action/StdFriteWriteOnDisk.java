package br.com.mind5.file.fileWrite.model.action;

import br.com.mind5.file.fileWrite.info.FriteInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFriteWriteOnDisk extends ActionStdTemplate<FriteInfo> {

	public StdFriteWriteOnDisk(DeciTreeOption<FriteInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FriteInfo> buildVisitorHook(DeciTreeOption<FriteInfo> option) {
		return new VisiFriteWriteOnDisk(option);
	}
}
