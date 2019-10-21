package br.com.mind5.business.cartItem.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.business.cartItem.model.action.LazyCartemSelect;
import br.com.mind5.business.cartItem.model.action.StdCartemEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemCheckHasItem extends ModelCheckerTemplateAction_<CartemInfo> {
	
	public CartemCheckHasItem(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<CartemInfo> buildActionHook(CartemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartemInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CartemInfo> actionSelect = new StdCartemEnforceKey(option);
		actionSelect.addPostAction(new LazyCartemSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CartemInfo> buildActionOption(CartemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartemInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_HAVE_ITEM)
			return SystemMessage.CART_HAVE_ITEM;
		
		return SystemMessage.CART_IS_EMPTY;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CART_HAVE_ITEM;	
		
		return SystemCode.CART_IS_EMPTY;
	}
}
