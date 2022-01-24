package br.com.mind5.business.personBio.model.action;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerbioMergeUsername extends ActionStdTemplate<PerbioInfo> {

	public StdPerbioMergeUsername(DeciTreeOption<PerbioInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerbioInfo> buildVisitorHook(DeciTreeOption<PerbioInfo> option) {
		return new VisiPerbioMergeUsername(option);
	}
}
