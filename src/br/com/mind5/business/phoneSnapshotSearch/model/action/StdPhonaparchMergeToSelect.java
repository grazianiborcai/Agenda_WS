package br.com.mind5.business.phoneSnapshotSearch.model.action;

import br.com.mind5.business.phoneSnapshotSearch.info.PhonaparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPhonaparchMergeToSelect extends ActionStdTemplate<PhonaparchInfo> {

	public StdPhonaparchMergeToSelect(DeciTreeOption<PhonaparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PhonaparchInfo> buildVisitorHook(DeciTreeOption<PhonaparchInfo> option) {
		return new VisiPhonaparchMergeToSelect(option);
	}
}
