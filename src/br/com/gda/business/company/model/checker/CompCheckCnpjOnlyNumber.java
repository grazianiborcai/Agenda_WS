package br.com.gda.business.company.model.checker;

import java.sql.Connection;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

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
