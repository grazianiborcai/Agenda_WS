package br.com.mind5.security.userSnapshot.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class StdUserapMergePhonap extends ActionStdTemplateV2<UserapInfo> {

	public StdUserapMergePhonap(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<UserapInfo> buildVisitorHook(DeciTreeOption<UserapInfo> option) {
		return new VisiUserapMergePhonap(option);
	}
}
