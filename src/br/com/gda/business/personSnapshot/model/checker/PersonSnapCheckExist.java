package br.com.gda.business.personSnapshot.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.action.StdPersonSnapSelect;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonSnapCheckExist extends ModelCheckerTemplateAction<PersonSnapInfo> {
	
	public PersonSnapCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PersonSnapInfo> buildActionHook(PersonSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonSnapInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PersonSnapInfo> actionSelect = new StdPersonSnapSelect(option);
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<PersonSnapInfo> buildActionOption(PersonSnapInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonSnapInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.PERSON_SNAPSHOT_ALREADY_EXIST)
			return SystemMessage.PERSON_SNAPSHOT_ALREADY_EXIST;
		
		return SystemMessage.PERSON_SNAPSHOT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PERSON_SNAPSHOT_ALREADY_EXIST;	
			
		return SystemCode.PERSON_SNAPSHOT_NOT_FOUND;
	}
}
