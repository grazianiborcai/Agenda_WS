package br.com.mind5.business.company.model.checker;

import java.sql.Connection;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompCheckNameLength extends ModelCheckerTemplateSimpleV2<CompInfo> {
	private int MAX_LENGTH = 30;

	public CompCheckNameLength(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.name == null)			
			return super.FAILED;		
		
		if ( checkNameLength(recordInfo) == super.FAILED)			
			return super.FAILED;	
		
		return super.SUCCESS;
	}
	
	
	
	private boolean checkNameLength(CompInfo recordInfo) {
		return recordInfo.name.length() <= MAX_LENGTH;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_MANDATORY_MAX_LENGTH_EXCEEDED;
	}
}
