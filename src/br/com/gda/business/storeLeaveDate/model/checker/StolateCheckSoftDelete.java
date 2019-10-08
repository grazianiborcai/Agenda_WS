package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceDel;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateSelectKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolateCheckSoftDelete extends ModelCheckerTemplateAction_<StolateInfo> {
	
	public StolateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(StolateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolateInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StolateInfo> actionSelect = new StdStolateEnforceDel(option);
		actionSelect.addPostAction(new LazyStolateSelectKey(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StolateInfo> buildActionOption(StolateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolateInfo> option = new DeciTreeOption<>();
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
