package br.com.mind5.business.materialStoreSearch.model.action;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatorarchDaoSelect extends ActionStdTemplateV2<MatorarchInfo> {

	public StdMatorarchDaoSelect(DeciTreeOption<MatorarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatorarchInfo> buildVisitorHook(DeciTreeOption<MatorarchInfo> option) {
		return new VisiMatorarchDaoSelect(option);
	}
}
