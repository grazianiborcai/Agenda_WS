package br.com.mind5.business.materialCatalogue.model.action;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatogueObfuscateStolis extends ActionStdTemplateV2<MatogueInfo> {

	public StdMatogueObfuscateStolis(DeciTreeOption<MatogueInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatogueInfo> buildVisitorHook(DeciTreeOption<MatogueInfo> option) {
		return new VisiMatogueEObfuscateStolis(option);
	}
}
