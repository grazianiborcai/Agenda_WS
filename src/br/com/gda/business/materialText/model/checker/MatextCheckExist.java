package br.com.gda.business.materialText.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextSelect;
import br.com.gda.business.materialText.model.action.StdMatextEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class MatextCheckExist extends ModelCheckerTemplateAction<MatextInfo> {	
	
	public MatextCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> buildActionHook(MatextInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatextInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatextInfo> enforceKey = new StdMatextEnforceKey(option);
		ActionLazy<MatextInfo> select = new LazyMatextSelect(conn, schemaName);		
		
		enforceKey.addPostAction(select);
		
		return enforceKey;
	}
	
	
	
	private DeciTreeOption<MatextInfo> buildOption(MatextInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatextInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_TEXT_ALREADY_EXIST)
			return SystemMessage.MAT_TEXT_ALREADY_EXIST;
		
		return SystemMessage.MAT_TEXT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_TEXT_ALREADY_EXIST;	
			
		return SystemCode.MAT_TEXT_NOT_FOUND;
	}
}
