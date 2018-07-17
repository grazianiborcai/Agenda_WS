package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.business.masterData.model.decisionTree.ActionEmpPosSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpPosCheckExist extends ModelCheckerTemplateAction<EmpPosInfo> {
	
	public EmpPosCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected DeciAction<EmpPosInfo> buildActionHook(EmpPosInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpPosInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		DeciAction<EmpPosInfo> actionSelect = new ActionEmpPosSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<EmpPosInfo> buildActionOption(EmpPosInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<EmpPosInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_POS_ALREADY_EXIST)
			return SystemMessage.EMP_POS_ALREADY_EXIST;
		
		return SystemMessage.EMP_POS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.EMP_POS_ALREADY_EXIST;	
			
		return SystemCode.EMP_POS_NOT_FOUND;
	}
}
