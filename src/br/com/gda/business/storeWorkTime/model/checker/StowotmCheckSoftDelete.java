package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.business.storeWorkTime.model.action.LazyStowotmSelect;
import br.com.gda.business.storeWorkTime.model.action.StdStowotmEnforceDel;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StowotmCheckSoftDelete extends ModelCheckerTemplateAction_<StowotmInfo> {

	public StowotmCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StowotmInfo> buildActionHook(StowotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StowotmInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<StowotmInfo> actionSelect = new StdStowotmEnforceDel(option);
		actionSelect.addPostAction(new LazyStowotmSelect(conn, schemaName));		
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<StowotmInfo> buildActionOption(StowotmInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StowotmInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_WTIME_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		return SystemCode.STORE_WTIME_FLAGGED_AS_DELETED;	
	}
}
