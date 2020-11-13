package br.com.mind5.business.ownerSnapshot.model.action;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOwnerapMergeComplis extends ActionStdTemplate<OwnerapInfo> {

	public StdOwnerapMergeComplis(DeciTreeOption<OwnerapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OwnerapInfo> buildVisitorHook(DeciTreeOption<OwnerapInfo> option) {
		return new VisiOwnerapMergeComplis(option);
	}
}
