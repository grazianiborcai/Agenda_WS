package br.com.gda.business.materialMovement.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.model.action.LazyMatmovSelect;
import br.com.gda.business.materialMovement.model.action.StdMatmovEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatmovCheckExist extends ModelCheckerTemplateAction<MatmovInfo> {
	
	public MatmovCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatmovInfo> buildActionHook(MatmovInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatmovInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatmovInfo> actionSelect = new StdMatmovEnforceKey(option);
		actionSelect.addPostAction(new LazyMatmovSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatmovInfo> buildOption(MatmovInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatmovInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_MOV_ALREADY_EXIST)
			return SystemMessage.MAT_MOV_ALREADY_EXIST;
		
		return SystemMessage.MAT_MOV_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_MOV_ALREADY_EXIST;	
			
		return SystemCode.MAT_MOV_NOT_FOUND;
	}
}
