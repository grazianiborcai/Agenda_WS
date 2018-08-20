package br.com.gda.business.material.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.ActionMatSelect;
import br.com.gda.business.material.model.decisionTree.HandlerMatFilterNonServ;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatCheckServ extends ModelCheckerTemplateAction<MatInfo> {
	
	public MatCheckServ(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<MatInfo> buildActionHook(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<MatInfo> actionSelect = new ActionMatSelect(option);
		actionSelect.addPostAction(new HandlerMatFilterNonServ(conn, schemaName));
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
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.MAT_SERVICE)
			return SystemMessage.MAT_SERVICE;
		
		return SystemMessage.MAT_NOT_SERVICE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.MAT_SERVICE;	
			
		return SystemCode.MAT_NOT_SERVICE;
	}
}
