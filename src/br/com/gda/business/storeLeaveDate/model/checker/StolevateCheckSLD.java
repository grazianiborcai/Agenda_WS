package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateSelectRange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolevateCheckSLD extends ModelCheckerTemplateAction_<StolevateInfo> {
	
	public StolevateCheckSLD(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StolevateInfo> buildActionHook(StolevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolevateInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<StolevateInfo> actionSelect = new StdStolevateSelectRange(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StolevateInfo> buildOption(StolevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolevateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_WTIME_NO_LEAVE_FOUND)
			return SystemMessage.STORE_WTIME_NO_LEAVE_FOUND;
		
		return SystemMessage.STORE_WTIME_LEAVE_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_WTIME_LEAVE_FOUND;	
			
		return SystemCode.STORE_WTIME_NO_LEAVE_FOUND;
	}
}
