package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.decisionTree.ActionGenderSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class GenderCheckExist extends ModelCheckerTemplateAction<GenderInfo> {
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<GenderInfo> buildActionHook(GenderInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<GenderInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<GenderInfo> actionSelect = new ActionGenderSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<GenderInfo> buildActionOption(GenderInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<GenderInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.GENDER_ALREADY_EXIST)
			return SystemMessage.GENDER_ALREADY_EXIST;
		
		return SystemMessage.GENDER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.GENDER_ALREADY_EXIST;	
			
		return SystemCode.GENDER_NOT_FOUND;
	}
}
