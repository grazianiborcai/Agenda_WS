package br.com.mind5.business.materialGroupStore.model.action;

import br.com.mind5.business.materialGroupStore.info.MatoporeInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoporeMergeMatore extends ActionStdTemplateV2<MatoporeInfo> {

	public StdMatoporeMergeMatore(DeciTreeOption<MatoporeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatoporeInfo> buildVisitorHook(DeciTreeOption<MatoporeInfo> option) {
		return new VisiMatoporeMergeMatore(option);
	}
}
