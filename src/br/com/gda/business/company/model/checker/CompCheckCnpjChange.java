package br.com.gda.business.company.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.LazyCompSelect;
import br.com.gda.business.company.model.action.StdCompEnforceCnpjChange;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CompCheckCnpjChange extends ModelCheckerTemplateAction<CompInfo> {
	
	public CompCheckCnpjChange(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CompInfo> buildActionHook(CompInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CompInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CompInfo> actionSelect = new StdCompEnforceCnpjChange(option);
		actionSelect.addPostAction(new LazyCompSelect(conn, schemaName));
		return actionSelect;
	}
	
	
	
	private DeciTreeOption<CompInfo> buildActionOption(CompInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CompInfo> option = new DeciTreeOption<>();
		option.recordInfos = new ArrayList<>();
		option.recordInfos.add(recordInfo);
		option.conn = conn;
		option.schemaName = schemaName;
		
		return option;
	}
	
	
	
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.COMPANY_CNPJ_NOT_CHANGED)
			return SystemMessage.COMPANY_CNPJ_NOT_CHANGED;
		
		return SystemMessage.COMPANY_CNPJ_CANT_BE_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.COMPANY_CNPJ_NOT_CHANGED;	
			
		return SystemCode.COMPANY_CNPJ_CANT_BE_CHANGED;
	}
}
