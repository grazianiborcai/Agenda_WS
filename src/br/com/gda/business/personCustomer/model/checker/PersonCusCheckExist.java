package br.com.gda.business.personCustomer.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonCusCheckExist extends ModelCheckerTemplateAction<PersonCusInfo> {
	
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
