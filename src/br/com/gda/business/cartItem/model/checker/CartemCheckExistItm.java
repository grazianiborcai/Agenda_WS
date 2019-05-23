package br.com.gda.business.cartItem.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.StdCartemSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CartemCheckExistItm extends ModelCheckerTemplateSimple<CartemInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CartemCheckExistItm(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CartemInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<CartemInfo> cartItens = selectCartItem(recordInfo, conn, schemaName);
			
			if (cartItens == null || cartItens.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<CartemInfo> selectCartItem(CartemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartemInfo> option = buildOption(recordInfo, conn, schemaName);		
		
		ActionStd<CartemInfo> selectCartItem = new StdCartemSelect(option);		
		selectCartItem.executeAction();
		
		if (selectCartItem.getDecisionResult().hasResultset())
			return selectCartItem.getDecisionResult().getResultset();
		
		return Collections.emptyList();		
	}
	
	
	
	private DeciTreeOption<CartemInfo> buildOption(CartemInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CartemInfo> newOption = new DeciTreeOption<>();
		
		newOption.recordInfos = new ArrayList<>();
		newOption.recordInfos.add(recordInfo);
		newOption.conn = conn;
		newOption.schemaName = schemaName;
		
		return newOption;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CART_ITEM_ALREADY_EXIST)
			return SystemMessage.CART_ITEM_ALREADY_EXIST;
		
		return SystemMessage.CART_ITEM_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.CART_ITEM_ALREADY_EXIST;	
			
		return SystemCode.CART_ITEM_NOT_FOUND;
	}
}
