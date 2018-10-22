package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.action.StdMatUnitSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatUnitCheckExist extends ModelCheckerTemplateAction<MatUnitInfo> {
	
	public MatUnitCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatUnitInfo> buildActionHook(MatUnitInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatUnitInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatUnitInfo> actionSelect = new StdMatUnitSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatUnitInfo> buildActionOption(MatUnitInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatUnitInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.UNIT_ALREADY_EXIST)
			return SystemMessage.UNIT_ALREADY_EXIST;
		
		return SystemMessage.UNIT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.UNIT_ALREADY_EXIST;	
			
		return SystemCode.UNIT_NOT_FOUND;
	}
}
