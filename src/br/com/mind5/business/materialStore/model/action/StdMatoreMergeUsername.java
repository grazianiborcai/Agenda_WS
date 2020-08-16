package br.com.mind5.business.materialStore.model.action;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatoreMergeUsername extends ActionStdTemplateV2<MatoreInfo> {

	public StdMatoreMergeUsername(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatoreInfo> buildVisitorHook(DeciTreeOption<MatoreInfo> option) {
		return new VisiMatoreMergeUsername(option);
	}
}
