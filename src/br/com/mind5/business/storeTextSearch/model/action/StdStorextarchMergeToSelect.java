package br.com.mind5.business.storeTextSearch.model.action;

import br.com.mind5.business.storeTextSearch.info.StorextarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStorextarchMergeToSelect extends ActionStdTemplateV2<StorextarchInfo> {

	public StdStorextarchMergeToSelect(DeciTreeOption<StorextarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StorextarchInfo> buildVisitorHook(DeciTreeOption<StorextarchInfo> option) {
		return new VisiStorextarchMergeToSelect(option);
	}
}
