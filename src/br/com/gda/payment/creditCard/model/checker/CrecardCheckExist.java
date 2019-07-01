package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.StdCrecardEnforceKey;
import br.com.gda.payment.creditCard.model.action.LazyCrecardSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CrecardCheckExist extends ModelCheckerTemplateAction<CrecardInfo> {	
	
	public CrecardCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CrecardInfo> buildActionHook(CrecardInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CrecardInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<CrecardInfo> actionSelect = new StdCrecardEnforceKey(option);
		actionSelect.addPostAction(new LazyCrecardSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CrecardInfo> buildOption(CrecardInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CrecardInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.CREDIT_CARD_ALREADY_EXIST)
			return SystemMessage.CREDIT_CARD_ALREADY_EXIST;
		
		return SystemMessage.CREDIT_CARD_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.CREDIT_CARD_ALREADY_EXIST;	
			
		return SystemCode.CREDIT_CARD_NOT_FOUND;
	}
}
