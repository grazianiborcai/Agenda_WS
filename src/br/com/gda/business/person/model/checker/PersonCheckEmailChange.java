package br.com.gda.business.person.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonSelect;
import br.com.gda.business.person.model.action.StdPersonEnforceEmailChange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonCheckEmailChange extends ModelCheckerTemplateAction<PersonInfo> {
	//TODO: deveria retornar TRUE se houvesse modificacao
	public PersonCheckEmailChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PersonInfo> buildActionHook(PersonInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PersonInfo> actionSelect = new StdPersonEnforceEmailChange(option);
		actionSelect.addPostAction(new LazyPersonSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PersonInfo> buildActionOption(PersonInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PERSON_EMAIL_NOT_CHANGED)
			return SystemMessage.PERSON_EMAIL_NOT_CHANGED;
		
		return SystemMessage.PERSON_EMAIL_CANT_BE_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PERSON_EMAIL_NOT_CHANGED;	
			
		return SystemCode.PERSON_EMAIL_CANT_BE_CHANGED;
	}
}
