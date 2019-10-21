package br.com.mind5.payment.customerPartner.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.customerPartner.model.action.LazyCusparSelect;
import br.com.mind5.payment.customerPartner.model.action.StdCusparEnforceUserKey;

public final class CusparCheckExistByUser extends ModelCheckerTemplateAction_<CusparInfo> {
	
	public CusparCheckExistByUser(ModelCheckerOption option) {
		super(option);
	}
	

	
	@Override protected ActionStd<CusparInfo> buildActionHook(CusparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CusparInfo> actionSelect = new StdCusparEnforceUserKey(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_CUS_USER_ALREADY_EXIST)
			return SystemMessage.PAY_CUS_USER_ALREADY_EXIST;
		
		return SystemMessage.PAY_CUS_USER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_CUS_USER_ALREADY_EXIST;	
		
		return SystemCode.PAY_CUS_USER_NOT_FOUND;
	}
}
