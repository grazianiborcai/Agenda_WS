package br.com.mind5.business.scheduleLineSnapshot.model.action;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdSchedinapMergeMatlis extends ActionStdTemplate<SchedinapInfo> {

	public StdSchedinapMergeMatlis(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<SchedinapInfo> buildVisitorHook(DeciTreeOption<SchedinapInfo> option) {
		return new VisiSchedinapMergeMatlis(option);
	}
}
