package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.action.StdPayparSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PayparCheckExist extends ModelCheckerTemplateAction_<PayparInfo> {
	
	public PayparCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PayparInfo> buildActionHook(PayparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayparInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PayparInfo> actionSelect = new StdPayparSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PayparInfo> buildActionOption(PayparInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PayparInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PAY_PARTNER_ALREADY_EXIST)
			return SystemMessage.PAY_PARTNER_ALREADY_EXIST;
		
		return SystemMessage.PAY_PARTNER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PAY_PARTNER_ALREADY_EXIST;	
			
		return SystemCode.PAY_PARTNER_NOT_FOUND;
	}
}
