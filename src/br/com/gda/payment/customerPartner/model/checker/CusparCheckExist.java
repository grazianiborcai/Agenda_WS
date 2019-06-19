package br.com.gda.payment.customerPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.action.LazyCusparSelect;
import br.com.gda.payment.customerPartner.model.action.StdCusparEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CusparCheckExist extends ModelCheckerTemplateAction<CusparInfo> {
	
	public CusparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<CusparInfo> buildActionHook(CusparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CusparInfo> actionSelect = new StdCusparEnforceKey(option);
		actionSelect.addPostAction(new LazyCusparSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CusparInfo> buildActionOption(CusparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusparInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CART_ALREADY_EXIST)
			return SystemMessage.CART_ALREADY_EXIST;
		
		return SystemMessage.CART_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CART_ALREADY_EXIST;	
		
		return SystemCode.CART_NOT_FOUND;
	}
}
