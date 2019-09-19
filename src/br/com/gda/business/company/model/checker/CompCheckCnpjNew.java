package br.com.gda.business.company.model.checker;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.model.action.LazyCompFilterCnpjNull;
import br.com.gda.business.company.model.action.LazyCompSelect;
import br.com.gda.business.company.model.action.StdCompEnforceKey;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateAction_;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class CompCheckCnpjNew extends ModelCheckerTemplateAction_<CompInfo> {
	
	public CompCheckCnpjNew(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ActionStd<CompInfo> buildActionHook(CompInfo recordInfo, Connection conn, String schemaName) {
		DeciTreeOption<CompInfo> option = buildActionOption(recordInfo, conn, schemaName);
		
		ActionStd<CompInfo> enforceKey = new StdCompEnforceKey(option);
		ActionLazy<CompInfo> select = new LazyCompSelect(conn, schemaName);
		ActionLazy<CompInfo> filterCnpj = new LazyCompFilterCnpjNull(conn, schemaName);
		
		enforceKey.addPostAction(select);
		select.addPostAction(filterCnpj);
		
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
	
	
	//TODO: a mensagem e realmente essa ?
	@Override protected String makeFailExplanationHook(boolean checkerResult) {		
		if (makeFailCodeHook(checkerResult) == SystemCode.COMPANY_CNPJ_CANT_BE_CHANGED)
			return SystemMessage.COMPANY_CNPJ_CANT_BE_CHANGED;
		
		return SystemMessage.COMPANY_CNPJ_NOT_CHANGED;
	}
	
	
	
	@Override protected int makeFailCodeHook(boolean checkerResult) {
		if (checkerResult == ALREADY_EXIST)
			return SystemCode.COMPANY_CNPJ_CANT_BE_CHANGED;	
			
		return SystemCode.COMPANY_CNPJ_NOT_CHANGED;
	}
}
