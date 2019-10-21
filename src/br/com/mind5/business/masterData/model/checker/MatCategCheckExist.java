package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.business.masterData.model.action.StdMatCategSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCategCheckExist extends ModelCheckerTemplateAction_<MatCategInfo> {
	
	public MatCategCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatCategInfo> buildActionHook(MatCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatCategInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatCategInfo> actionSelect = new StdMatCategSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatCategInfo> buildActionOption(MatCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatCategInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_CATEG_ALREADY_EXIST)
			return SystemMessage.MAT_CATEG_ALREADY_EXIST;
		
		return SystemMessage.MAT_CATEG_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_CATEG_ALREADY_EXIST;	
			
		return SystemCode.MAT_CATEG_NOT_FOUND;
	}
}
