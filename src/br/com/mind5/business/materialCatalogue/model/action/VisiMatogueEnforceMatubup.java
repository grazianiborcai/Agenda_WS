package br.com.mind5.business.materialCatalogue.model.action;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.materialCatalogue.info.MatogueSetterMatubup;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.model.action.ActionVisitorTemplateEnforceV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiMatogueEnforceMatubup extends ActionVisitorTemplateEnforceV2<MatogueInfo> {
	
	public VisiMatogueEnforceMatubup(DeciTreeOption<MatogueInfo> option) {
		super(option);
	}
	
	
	
	@Override protected MatogueInfo enforceHook(MatogueInfo recordInfo) {
		InfoSetter<MatogueInfo> attrSetter = new MatogueSetterMatubup();
		return attrSetter.setAttr(recordInfo);
	}
}