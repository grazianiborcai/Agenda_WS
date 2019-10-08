package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.model.action.LazyStolateSelectKey;
import br.com.gda.business.storeLeaveDate.model.action.StdStolateEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StolateCheckExist extends ModelCheckerTemplateAction_<StolateInfo> {
	
	public StolateCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<StolateInfo> buildActionHook(StolateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolateInfo> option = buildOption(recordInfo, conn, schemaName);		
		
		ActionStd<StolateInfo> enforceKey = new StdStolateEnforceKey(option);
		ActionLazy<StolateInfo> select = new LazyStolateSelectKey(option.conn, option.schemaName);
		
		enforceKey.addPostAction(select);		
		return enforceKey;
	}
	
	
	
	private DeciTreeOption<StolateInfo> buildOption(StolateInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<StolateInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.STORE_LDATE_ALREADY_EXIST)
			return SystemMessage.STORE_LDATE_ALREADY_EXIST;
		
		return SystemMessage.STORE_LDATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.STORE_LDATE_ALREADY_EXIST;	
			
		return SystemCode.STORE_LDATE_NOT_FOUND;
	}
}
