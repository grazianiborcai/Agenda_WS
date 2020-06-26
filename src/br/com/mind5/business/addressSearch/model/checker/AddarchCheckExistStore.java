package br.com.mind5.business.addressSearch.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.RootAddarchSelectStore;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddarchCheckExistStore extends ModelCheckerTemplateActionV2<AddarchInfo, AddarchInfo> {
	
	public AddarchCheckExistStore(ModelCheckerOption option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<AddarchInfo> buildActionHook(DeciTreeOption<AddarchInfo> option) {
		ActionStdV1<AddarchInfo> select = new RootAddarchSelectStore(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SEARCH_NOT_FOUND;
	}
}
