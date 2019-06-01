package br.com.gda.business.cartSnapshot_.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot_.model.action.LazyCartSnapSelect;
import br.com.gda.business.cartSnapshot_.model.action.StdCartSnapEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartSnapCheckExist extends ModelCheckerTemplateAction<CartSnapInfo> {
	
	public CartSnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CartSnapInfo> buildActionHook(CartSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartSnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CartSnapInfo> actionSelect = new StdCartSnapEnforceKey(option);
		actionSelect.addPostAction(new LazyCartSnapSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CartSnapInfo> buildActionOption(CartSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartSnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.CART_SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.CART_SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.CART_SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.CART_SNAPSHOT_NOT_FOUND;
	}
}
