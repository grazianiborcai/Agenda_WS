package br.com.mind5.business.personUser_.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.business.personUser_.model.decisionTree.RootPersonUserSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonUserCheckExist extends ModelCheckerTemplateAction_<PersonUserInfo> {
	
	public PersonUserCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PersonUserInfo> buildActionHook(PersonUserInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonUserInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<PersonUserInfo> actionSelect = new RootPersonUserSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PersonUserInfo> buildOption(PersonUserInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonUserInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PERSON_USER_ALREADY_EXIST)
			return SystemMessage.PERSON_USER_ALREADY_EXIST;
		
		return SystemMessage.PERSON_USER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PERSON_USER_ALREADY_EXIST;	
			
		return SystemCode.PERSON_USER_NOT_FOUND;
	}
}
