package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.action.StdMatUnitSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatUnitCheckExist extends ModelCheckerTemplateAction_<MatUnitInfo> {
	
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.UNIT_ALREADY_EXIST)
			return SystemMessage.UNIT_ALREADY_EXIST;
		
		return SystemMessage.UNIT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.UNIT_ALREADY_EXIST;	
			
		return SystemCode.UNIT_NOT_FOUND;
	}
}
