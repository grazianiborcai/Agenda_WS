package br.com.gda.business.person.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonFilterCpfFilled;
import br.com.gda.business.person.model.action.LazyPersonSelect;
import br.com.gda.business.person.model.action.StdPersonEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class PersonCheckCpfErasured extends ModelCheckerTemplateAction<PersonInfo> {
	
	public PersonCheckCpfErasured(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<PersonInfo> buildActionHook(PersonInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<PersonInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<PersonInfo> enforceKey = new StdPersonEnforceKey(option);
		ActionLazy<PersonInfo> select = new LazyPersonSelect(conn, schemaName);
		ActionLazy<PersonInfo> filter = new LazyPersonFilterCpfFilled(conn, schemaName);
		
		enforceKey.addPostAction(select);
		select.addPostAction(filter);
		
		return enforceKey;
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
		if (makeFailCodeHook(checkerResult) == SystemCode.PERSON_CPF_NOT_ERASURED)
			return SystemMessage.PERSON_CPF_NOT_ERASURED;
		
		return SystemMessage.PERSON_CPF_ERASURED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.PERSON_CPF_ERASURED;	
			
		return SystemCode.PERSON_CPF_ERASURED;
	}
}
