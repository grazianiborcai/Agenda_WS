package br.com.mind5.business.personBioList.model.action;

import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbiolisMergePerbioSelectFallback extends ActionStdTemplate<PerbiolisInfo> {

	public StdPerbiolisMergePerbioSelectFallback(DeciTreeOption<PerbiolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerbiolisInfo> buildVisitorHook(DeciTreeOption<PerbiolisInfo> option) {
		return new VisiPerbiolisMergePerbioSelectFallback(option);
	}
}
