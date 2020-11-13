package br.com.mind5.business.materialCatalogue.model.action;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatogueObfuscateStolis extends ActionStdTemplate<MatogueInfo> {

	public StdMatogueObfuscateStolis(DeciTreeOption<MatogueInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatogueInfo> buildVisitorHook(DeciTreeOption<MatogueInfo> option) {
		return new VisiMatogueEObfuscateStolis(option);
	}
}
