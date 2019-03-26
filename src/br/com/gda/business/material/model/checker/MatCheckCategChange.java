package br.com.gda.business.material.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.action.LazyMatSelect;
import br.com.gda.business.material.model.action.StdMatEnforceCategKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatCheckCategChange extends ModelCheckerTemplateAction<MatInfo> {

	public MatCheckCategChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatInfo> buildActionHook(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<MatInfo> enforceCategKey = new StdMatEnforceCategKey(option);
		ActionLazy<MatInfo> select = new LazyMatSelect(option.conn, option.schemaName);
		
		enforceCategKey.addPostAction(select);
		return enforceCategKey;
	}
	
	
	
	private DeciTreeOption<MatInfo> buildActionOption(MatInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_CATEG_NOT_CHANGED)
			return SystemMessage.MAT_CATEG_NOT_CHANGED;
		
		return SystemMessage.MAT_CATEG_CANT_BE_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_CATEG_NOT_CHANGED;	
			
		return SystemCode.MAT_CATEG_CANT_BE_CHANGED;
	}
}
