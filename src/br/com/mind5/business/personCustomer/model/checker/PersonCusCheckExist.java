package br.com.mind5.business.personCustomer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.mind5.business.personCustomer.info.PersonCusInfo;
import br.com.mind5.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction_;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonCusCheckExist extends ModelCheckerTemplateAction_<PersonCusInfo> {
	
	public PersonCusCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PersonCusInfo> buildActionHook(PersonCusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonCusInfo> option = buildOption(recordInfo, conn, schemaName);
		
		ActionStd<PersonCusInfo> actionSelect = new RootPersonCusSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PersonCusInfo> buildOption(PersonCusInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonCusInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PERSON_CUS_ALREADY_EXIST)
			return SystemMessage.PERSON_CUS_ALREADY_EXIST;
		
		return SystemMessage.PERSON_CUS_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == super.ALREADY_EXIST)
			return SystemCode.PERSON_CUS_ALREADY_EXIST;	
			
		return SystemCode.PERSON_CUS_NOT_FOUND;
	}
}
