package br.com.mind5.business.cartItemSearch.model.checker;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.RootCartemarchSelectUser;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemarchCheckExistUser extends ModelCheckerTemplateAction<CartemarchInfo, CartemarchInfo> {
	
	public CartemarchCheckExistUser(ModelCheckerOption option) {
		super(option, CartemarchInfo.class);
	}
	
	
	
	@Override protected ActionStd<CartemarchInfo> buildActionHook(DeciTreeOption<CartemarchInfo> option) {
		ActionStd<CartemarchInfo> select = new RootCartemarchSelectUser(option).toAction();
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_ITEM_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_SEARCH_NOT_FOUND;
	}
}
