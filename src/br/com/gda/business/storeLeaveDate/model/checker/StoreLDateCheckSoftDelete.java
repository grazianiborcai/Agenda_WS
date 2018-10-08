package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.ActionStoreLDateEnforceDel;
import br.com.gda.business.storeLeaveDate.model.decisionTree.HandlerStoreLDateSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreLDateCheckSoftDelete extends ModelCheckerTemplateAction<StoreLDateInfo> {
	
	public StoreLDateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StoreLDateInfo> buildActionHook(StoreLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreLDateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StoreLDateInfo> actionSelect = new ActionStoreLDateEnforceDel(option);
		actionSelect.addPostAction(new HandlerStoreLDateSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreLDateInfo> buildActionOption(StoreLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreLDateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_LDATE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;	
	}
}
