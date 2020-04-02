package br.com.mind5.business.cartItemSearch.model.checker;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.RootCartemarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemarchCheckExist extends ModelCheckerTemplateAction<CartemarchInfo, CartemarchInfo> {
	
	public CartemarchCheckExist(ModelCheckerOption option) {
		super(option, CartemarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV1<CartemarchInfo> buildActionHook(DeciTreeOption<CartemarchInfo> option) {
		ActionStdV1<CartemarchInfo> select = new RootCartemarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_ITEM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_SEARCH_NOT_FOUND;
	}
}
