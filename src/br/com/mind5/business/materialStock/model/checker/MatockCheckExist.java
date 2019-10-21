package br.com.mind5.business.materialStock.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.LazyMatockSelect;
import br.com.mind5.business.materialStock.model.action.StdMatockEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatockCheckExist extends ModelCheckerTemplateAction_<MatockInfo> {
	
	public MatockCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatockInfo> buildActionHook(MatockInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatockInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatockInfo> actionSelect = new StdMatockEnforceKey(option);
		actionSelect.addPostAction(new LazyMatockSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<MatockInfo> buildOption(MatockInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatockInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_STOCK_ALREADY_EXIST)
			return SystemMessage.MAT_STOCK_ALREADY_EXIST;
		
		return SystemMessage.MAT_STOCK_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_MOV_ALREADY_EXIST;	
			
		return SystemCode.MAT_MOV_NOT_FOUND;
	}
}
