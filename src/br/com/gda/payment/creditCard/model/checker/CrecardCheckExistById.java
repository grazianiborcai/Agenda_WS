package br.com.gda.payment.creditCard.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.payment.creditCard.model.action.StdCrecardEnforceKeyId;
import br.com.gda.payment.creditCard.model.action.LazyCrecardSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CrecardCheckExistById extends ModelCheckerTemplateAction_<CrecardInfo> {	
	
	public CrecardCheckExistById(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CrecardInfo> buildActionHook(CrecardInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CrecardInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<CrecardInfo> actionSelect = new StdCrecardEnforceKeyId(option);
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
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_ALREADY_EXIST)
			return SystemMessage.MAT_ALREADY_EXIST;
		
		return SystemMessage.MAT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_ALREADY_EXIST;	
			
		return SystemCode.MAT_NOT_FOUND;
	}
}
