package br.com.mind5.business.storeTextSearch.model.action;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextarchMergeToSelect extends ActionStdTemplate<StorextarchInfo> {

	public StdStorextarchMergeToSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StorextarchInfo> buildVisitorHook(DeciTreeOption<StorextarchInfo> option) {
		return new VisiStorextarchMergeToSelect(option);
	}
}
