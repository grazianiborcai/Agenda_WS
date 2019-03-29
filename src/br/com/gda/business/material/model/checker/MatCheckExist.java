package br.com.gda.business.material.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.StdMatEnforceKey;
import br.com.gda.business.material.model.action.LazyMatSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatCheckExist extends ModelCheckerTemplateAction<MatInfo> {	
	
	public MatCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatInfo> buildActionHook(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatInfo> actionSelect = new StdMatEnforceKey(option);
		actionSelect.addPostAction(new LazyMatSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatInfo> buildOption(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = new DeciTreeOption<>();
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
