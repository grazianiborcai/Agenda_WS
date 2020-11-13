package br.com.mind5.business.cartItem.model.checker;

import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItemSearch.info.CartemarchCopier;
import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.RootCartemarchSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateActionV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemCheckLimit extends ModelCheckerTemplateActionV2<CartemInfo, CartemarchInfo> {
	private final int MAX_RECORD_COUNT = 20;
	
	
	public CartemCheckLimit(ModelCheckerOption option) {
		super(option, CartemarchInfo.class);
	}
	
	
	
	@Override protected ActionStdV2<CartemarchInfo> buildActionHook(DeciTreeOption<CartemarchInfo> option) {
		ActionStdV2<CartemarchInfo> select = new RootCartemarchSelect(option).toAction();
		return select;
	}
	
	
	
	@Override protected List<CartemarchInfo> toActionClassHook(List<CartemInfo> recordInfos) {
		return CartemarchCopier.copyFromCartemKey(recordInfos);
	}
	
	
	
	@Override protected int getMaxCountHook() {
		return MAX_RECORD_COUNT;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.CART_ITEM_LIMIT_NOT_REACHED;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.CART_ITEM_LIMIT_EXCEEDED;
	}
}
