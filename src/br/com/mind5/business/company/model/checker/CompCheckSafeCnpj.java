package br.com.mind5.business.company.model.checker;

import java.sql.Connection;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.common.StringValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CompCheckSafeCnpj extends ModelCheckerTemplateSimple<CompInfo> {

	public CompCheckSafeCnpj(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.cnpj == null)
			return super.SUCCESS;
		
		if (StringValidator.validateCodeNumber(recordInfo.cnpj) == super.SUCCESS)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_CONTAIN_INVALID_CHAR);
		builder.addParam01(SystemCode.COMPANY);
		builder.addParam02(SystemCode.COMPANY_CNPJ);

		return builder.build();
	}
}
