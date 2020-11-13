package br.com.mind5.business.phoneSnapshot.model.action;

import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdPhonapMergeFormone extends ActionStdTemplate<PhonapInfo> {

	public StdPhonapMergeFormone(DeciTreeOption<PhonapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhonapInfo> buildVisitorHook(DeciTreeOption<PhonapInfo> option) {
		return new VisiPhonapMergeFormone(option);
	}
}
