package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.business.storeLeaveDate.model.action.StdStolevateEnforceDel;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolevateSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolevateCheckSoftDelete extends ModelCheckerTemplateAction<StolevateInfo> {
	
	public StolevateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StolevateInfo> buildActionHook(StolevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolevateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StolevateInfo> actionSelect = new StdStolevateEnforceDel(option);
		actionSelect.addPostAction(new LazyStolevateSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StolevateInfo> buildActionOption(StolevateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolevateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_LDATE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;	
	}
}
