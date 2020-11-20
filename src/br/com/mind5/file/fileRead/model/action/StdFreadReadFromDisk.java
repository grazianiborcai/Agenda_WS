package br.com.mind5.file.fileRead.model.action;

import br.com.mind5.file.fileRead.info.FreadInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFreadReadFromDisk extends ActionStdTemplate<FreadInfo> {

	public StdFreadReadFromDisk(DeciTreeOption<FreadInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FreadInfo> buildVisitorHook(DeciTreeOption<FreadInfo> option) {
		return new VisiFreadReadFromDisk(option);
	}
}
