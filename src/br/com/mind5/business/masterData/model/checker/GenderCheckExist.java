package br.com.mind5.business.masterData.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.business.masterData.model.action.StdGenderSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class GenderCheckExist extends ModelCheckerTemplateAction_<GenderInfo> {
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<GenderInfo> buildActionHook(GenderInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<GenderInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<GenderInfo> actionSelect = new StdGenderSelect(option);
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
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.GENDER_ALREADY_EXIST)
			return SystemMessage.GENDER_ALREADY_EXIST;
		
		return SystemMessage.GENDER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.GENDER_ALREADY_EXIST;	
			
		return SystemCode.GENDER_NOT_FOUND;
	}
}
