package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatTypeSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatTypeCheckExist extends ModelCheckerTemplateAction_<MatTypeInfo> {
	
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
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_TYPE_ALREADY_EXIST;	
			
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
