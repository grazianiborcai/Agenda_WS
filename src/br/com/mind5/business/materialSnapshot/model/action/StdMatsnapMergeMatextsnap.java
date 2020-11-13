package br.com.mind5.business.materialSnapshot.model.action;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatsnapMergeMatextsnap extends ActionStdTemplate<MatsnapInfo> {

	public StdMatsnapMergeMatextsnap(DeciTreeOption<MatsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatsnapInfo> buildVisitorHook(DeciTreeOption<MatsnapInfo> option) {
		return new VisiMatsnapMergeMatextsnap(option);
	}
}
