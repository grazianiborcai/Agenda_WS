package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgysMergeToReplace extends ActionStdTemplate<FimgysInfo> {

	public StdFimgysMergeToReplace(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgysInfo> buildVisitorHook(DeciTreeOption<FimgysInfo> option) {
		return new VisiFimgysMergeToReplace(option);
	}
}
