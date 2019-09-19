package br.com.gda.business.company.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.LazyCompFilterCnpjFilled;
import br.com.gda.business.company.model.action.LazyCompSelect;
import br.com.gda.business.company.model.action.StdCompEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CompCheckCnpjErasure extends ModelCheckerTemplateAction_<CompInfo> {
	
	public CompCheckCnpjErasure(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CompInfo> buildActionHook(CompInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CompInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CompInfo> enforceKey = new StdCompEnforceKey(option);
		ActionLazy<CompInfo> select = new LazyCompSelect(conn, schemaName);
		ActionLazy<CompInfo> filter = new LazyCompFilterCnpjFilled(conn, schemaName);
		
		enforceKey.addPostAction(select);
		select.addPostAction(filter);
		
		return enforceKey;
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
		if (makeFailCodeHook(checkerResult) == SystemCode.COMPANY_CNPJ_NO_ERASURE)
			return SystemMessage.COMPANY_CNPJ_NO_ERASURE;
		
		return SystemMessage.COMPANY_CNPJ_ERASURE;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.COMPANY_CNPJ_ERASURE;	
			
		return SystemCode.COMPANY_CNPJ_ERASURE;
	}
}
