package br.com.mind5.business.materialText.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.model.action.LazyMatextEnforceDefaultOn;
import br.com.mind5.business.materialText.model.action.LazyMatextSelectDefault;
import br.com.mind5.business.materialText.model.action.StdMatextEnforceMatKey;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatextCheckHasDefault extends ModelCheckerTemplateAction_<MatextInfo> {	
	
	public MatextCheckHasDefault(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<MatextInfo> buildActionHook(MatextInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<MatextInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<MatextInfo> enforceMatKey = new StdMatextEnforceMatKey(option);
		ActionLazy<MatextInfo> enforceDefaultOn = new LazyMatextEnforceDefaultOn(conn, schemaName);		
		ActionLazy<MatextInfo> select = new LazyMatextSelectDefault(conn, schemaName);	
		
		enforceMatKey.addPostAction(enforceDefaultOn);
		enforceDefaultOn.addPostAction(select);
		
		return enforceMatKey;
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
		if (makeFailCodeHook(checkerResult) == SystemCode.MAT_TEXT_HAS_DEFAULT)
			return SystemMessage.MAT_TEXT_HAS_DEFAULT;
		
		return SystemMessage.MAT_TEXT_HAS_NO_DEFAULT;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.MAT_TEXT_HAS_DEFAULT;	
			
		return SystemCode.MAT_TEXT_HAS_NO_DEFAULT;
	}
}
