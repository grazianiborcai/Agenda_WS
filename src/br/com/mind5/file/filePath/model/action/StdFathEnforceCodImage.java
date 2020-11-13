package br.com.mind5.file.filePath.model.action;

import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFathEnforceCodImage extends ActionStdTemplate<FathInfo> {

	public StdFathEnforceCodImage(DeciTreeOption<FathInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FathInfo> buildVisitorHook(DeciTreeOption<FathInfo> option) {
		return new VisiFathEnforceCodImage(option);
	}
}
