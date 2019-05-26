package br.com.gda.business.cartItem.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.StdCartemSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartemCheckExist extends ModelCheckerTemplateAction<CartemInfo> {
	
	public CartemCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<CartemInfo> buildActionHook(CartemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartemInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CartemInfo> actionSelect = new StdCartemSelect(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_ITEM_ALREADY_EXIST)
			return SystemMessage.CART_ITEM_ALREADY_EXIST;
		
		return SystemMessage.CART_ITEM_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CART_ITEM_ALREADY_EXIST;	
		
		return SystemCode.CART_ITEM_NOT_FOUND;
	}
}
