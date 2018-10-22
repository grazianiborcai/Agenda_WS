package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.business.masterData.model.action.StdMatCategSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatCategCheckExist extends ModelCheckerTemplateAction<MatCategInfo> {
	
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
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.MAT_CATEG_ALREADY_EXIST)
			return SystemMessage.MAT_CATEG_ALREADY_EXIST;
		
		return SystemMessage.MAT_CATEG_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.MAT_CATEG_ALREADY_EXIST;	
			
		return SystemCode.MAT_CATEG_NOT_FOUND;
	}
}
