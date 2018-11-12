package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.action.StdMatTypeSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatTypeCheckExist extends ModelCheckerTemplateAction<MatTypeInfo> {
	
	public MatTypeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatTypeInfo> buildActionHook(MatTypeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatTypeInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatTypeInfo> actionSelect = new StdMatTypeSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatTypeInfo> buildActionOption(MatTypeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatTypeInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_TYPE_ALREADY_EXIST)
			return SystemMessage.MAT_TYPE_ALREADY_EXIST;
		
		return SystemMessage.MAT_TYPE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.MAT_TYPE_ALREADY_EXIST;	
			
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
