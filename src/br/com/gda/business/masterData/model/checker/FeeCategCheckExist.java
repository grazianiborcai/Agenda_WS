package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.business.masterData.model.decisionTree.ActionFeeCategSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class FeeCategCheckExist extends ModelCheckerTemplateAction<FeeCategInfo> {
	
	public FeeCategCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<FeeCategInfo> buildActionHook(FeeCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FeeCategInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<FeeCategInfo> actionSelect = new ActionFeeCategSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<FeeCategInfo> buildActionOption(FeeCategInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<FeeCategInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.FEE_CATEG_ALREADY_EXIST)
			return SystemMessage.FEE_CATEG_ALREADY_EXIST;
		
		return SystemMessage.FEE_CATEG_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.FEE_CATEG_ALREADY_EXIST;	
			
		return SystemCode.FEE_CATEG_NOT_FOUND;
	}
}
