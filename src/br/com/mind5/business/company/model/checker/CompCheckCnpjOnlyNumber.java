package br.com.mind5.business.company.model.checker;

import java.sql.Connection;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class CompCheckCnpjOnlyNumber extends ModelCheckerTemplateSimpleV2<CompInfo> {

	public CompCheckCnpjOnlyNumber(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.cnpj == null)
			return super.FAILED;
		
		if (recordInfo.cnpj.matches("^\\d+$"))			
			return super.SUCCESS;		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_CNPJ_INVALID_NUMBER;
	}
}
