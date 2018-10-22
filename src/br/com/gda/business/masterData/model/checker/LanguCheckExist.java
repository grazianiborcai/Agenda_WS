package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.action.StdLanguSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class LanguCheckExist extends ModelCheckerTemplateAction<LanguInfo> {
		
	public LanguCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<LanguInfo> buildActionHook(LanguInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<LanguInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<LanguInfo> actionSelect = new StdLanguSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<LanguInfo> buildActionOption(LanguInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<LanguInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.LANGUAGE_ALREADY_EXIST)
			return SystemMessage.LANGUAGE_ALREADY_EXIST;
		
		return SystemMessage.LANGUAGE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.LANGUAGE_ALREADY_EXIST;	
			
		return SystemCode.LANGUAGE_NOT_FOUND;
	}
}
