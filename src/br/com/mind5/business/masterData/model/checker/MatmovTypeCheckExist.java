package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.model.action.StdMatmovTypeSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatmovTypeCheckExist extends ModelCheckerTemplateAction_<MatmovTypeInfo> {
	
	public MatmovTypeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatmovTypeInfo> buildActionHook(MatmovTypeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatmovTypeInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatmovTypeInfo> actionSelect = new StdMatmovTypeSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatmovTypeInfo> buildActionOption(MatmovTypeInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatmovTypeInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_MOV_TYPE_ALREADY_EXIST)
			return SystemMessage.MAT_MOV_TYPE_ALREADY_EXIST;
		
		return SystemMessage.MAT_MOV_TYPE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_MOV_TYPE_ALREADY_EXIST;	
			
		return SystemCode.MAT_MOV_TYPE_NOT_FOUND;
	}
}
