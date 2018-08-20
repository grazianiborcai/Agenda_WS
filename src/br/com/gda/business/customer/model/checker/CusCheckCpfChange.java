package br.com.gda.business.customer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.decisionTree.ActionCusEnforceKeyCpf;
import br.com.gda.business.customer.model.decisionTree.HandlerCusSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CusCheckCpfChange extends ModelCheckerTemplateAction<CusInfo> {
	
	public CusCheckCpfChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<CusInfo> buildActionHook(CusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CusInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<CusInfo> actionSelect = new ActionCusEnforceKeyCpf(option);
		actionSelect.addPostAction(new HandlerCusSelect(conn, schemaName));
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
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.CUS_ALREADY_EXIST)
			return SystemMessage.CUS_ALREADY_EXIST;
		
		return SystemMessage.CUS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.CUS_ALREADY_EXIST;	
			
		return SystemCode.CUS_NOT_FOUND;
	}
}
