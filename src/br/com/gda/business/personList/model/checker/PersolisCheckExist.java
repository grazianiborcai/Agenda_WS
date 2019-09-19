package br.com.gda.business.personList.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.model.action.LazyPersolisSelect;
import br.com.gda.business.personList.model.action.StdPersolisEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersolisCheckExist extends ModelCheckerTemplateAction_<PersolisInfo> {
	
	public PersolisCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PersolisInfo> buildActionHook(PersolisInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersolisInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PersolisInfo> actionSelect = new StdPersolisEnforceKey(option);
		actionSelect.addPostAction(new LazyPersolisSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PersolisInfo> buildActionOption(PersolisInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersolisInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PERSON_ALREADY_EXIST)
			return SystemMessage.PERSON_ALREADY_EXIST;
		
		return SystemMessage.PERSON_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PERSON_ALREADY_EXIST;	
			
		return SystemCode.PERSON_NOT_FOUND;
	}
}
