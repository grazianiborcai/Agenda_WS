package br.com.mind5.business.material.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatSelect;
import br.com.mind5.business.material.model.action.StdMatEnforceKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatCheckExist extends ModelCheckerTemplateAction_<MatInfo> {	
	
	public MatCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatInfo> buildActionHook(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatInfo> enforceKey = new StdMatEnforceKey(option);
		ActionLazy<MatInfo> select = new LazyMatSelect(conn, schemaName);
		
		enforceKey.addPostAction(select);
		return enforceKey;
	}
	
	
	
	private DeciTreeOption<MatInfo> buildOption(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_ALREADY_EXIST)
			return SystemMessage.MAT_ALREADY_EXIST;
		
		return SystemMessage.MAT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_ALREADY_EXIST;	
			
		return SystemCode.MAT_NOT_FOUND;
	}
}
