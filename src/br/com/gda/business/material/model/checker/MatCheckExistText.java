package br.com.gda.business.material.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.ActionMatSelect;
import br.com.gda.business.material.model.decisionTree.HandlerMatFilterText;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatCheckExistText extends ModelCheckerTemplateAction<MatInfo> {
	
	public MatCheckExistText(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<MatInfo> buildActionHook(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		DeciAction<MatInfo> actionSelect = new ActionMatSelect(option);
		actionSelect.addPostAction(new HandlerMatFilterText(conn, schemaName));
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
		if (makeFailureCodeHook(checkerResult) == SystemCode.MATERIAL_TEXT_ALREADY_EXIST)
			return SystemMessage.MAT_TEXT_ALREALDY_EXIST;
		
		return SystemMessage.MAT_TEXT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.MATERIAL_TEXT_ALREADY_EXIST;	
			
		return SystemCode.MATERIAL_TEXT_NOT_FOUND;
	}
}
