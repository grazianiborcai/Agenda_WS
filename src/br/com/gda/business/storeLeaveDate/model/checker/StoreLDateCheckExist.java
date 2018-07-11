package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.decisionTree.ActionStoreLDateSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StoreLDateCheckExist extends ModelCheckerTemplateAction<StoreLDateInfo> {
	
	public StoreLDateCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<StoreLDateInfo> buildActionHook(StoreLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreLDateInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<StoreLDateInfo> actionSelect = new ActionStoreLDateSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StoreLDateInfo> buildOption(StoreLDateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StoreLDateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_LDATE_ALREADY_EXIST)
			return SystemMessage.STORE_LDATE_ALREADY_EXIST;
		
		return SystemMessage.STORE_LDATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_LDATE_ALREADY_EXIST;	
			
		return SystemCode.STORE_LDATE_NOT_FOUND;
	}
}
