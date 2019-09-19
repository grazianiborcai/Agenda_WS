package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.business.masterData.model.action.StdMatGroupSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatGroupCheckExist extends ModelCheckerTemplateAction_<MatGroupInfo> {
	
	public MatGroupCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatGroupInfo> buildActionHook(MatGroupInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatGroupInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatGroupInfo> actionSelect = new StdMatGroupSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatGroupInfo> buildActionOption(MatGroupInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatGroupInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_GROUP_ALREADY_EXIST)
			return SystemMessage.MAT_GROUP_ALREADY_EXIST;
		
		return SystemMessage.MAT_GROUP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_GROUP_ALREADY_EXIST;	
			
		return SystemCode.MAT_GROUP_NOT_FOUND;
	}
}
