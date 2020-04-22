package br.com.mind5.business.materialTextSearch.model.action;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatextarchMergeToSelect extends ActionStdTemplateV2<MatextarchInfo> {

	public StdMatextarchMergeToSelect(DeciTreeOption<MatextarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatextarchInfo> buildVisitorHook(DeciTreeOption<MatextarchInfo> option) {
		return new VisiMatextarchMergeToSelect(option);
	}
}
