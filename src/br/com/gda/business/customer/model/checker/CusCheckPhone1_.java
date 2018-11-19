package br.com.gda.business.customer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.action.StdCusValidatePhone1;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CusCheckPhone1 extends ModelCheckerTemplateAction<CusInfo> {
	
	public CusCheckPhone1(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CusInfo> buildActionHook(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CusInfo> actionSelect = new StdCusValidatePhone1(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CusInfo> buildActionOption(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PHONE_NUMBER_IS_VALID)
			return SystemMessage.PHONE_NUMBER_IS_VALID;
		
		return super.getActionFailExplanation();
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.SUCCESS)
			return SystemCode.PHONE_NUMBER_IS_VALID;	
			
		return super.getActionFailCode();
	}
}
