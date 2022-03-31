package br.com.mind5.business.addressSearch.model.checker;

import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.AddarchRootSelectStore;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddarchCheckExistStore extends ModelCheckerTemplateAction<AddarchInfo, AddarchInfo> {
	
	public AddarchCheckExistStore(ModelCheckerOption option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<AddarchInfo> buildActionHook(DeciTreeOption<AddarchInfo> option) {
		ActionStd<AddarchInfo> select = new AddarchRootSelectStore(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.ADDRESS_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.ADDRESS_SEARCH_NOT_FOUND;
	}
}
