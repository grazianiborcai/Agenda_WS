package br.com.mind5.business.storeTextSnapshot.model.action;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextsnapMergeToSelect extends ActionStdTemplate<StorextsnapInfo> {

	public StdStorextsnapMergeToSelect(DeciTreeOption<StorextsnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorextsnapInfo> buildVisitorHook(DeciTreeOption<StorextsnapInfo> option) {
		return new VisiStorextsnapMergeToSelect(option);
	}
}
