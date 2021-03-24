package br.com.mind5.file.sysFileImage.model.action;

import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdFimgysDaoSelect extends ActionStdTemplate<FimgysInfo> {

	public StdFimgysDaoSelect(DeciTreeOption<FimgysInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<FimgysInfo> buildVisitorHook(DeciTreeOption<FimgysInfo> option) {
		return new VisiFimgysDaoSelect(option);
	}
}
