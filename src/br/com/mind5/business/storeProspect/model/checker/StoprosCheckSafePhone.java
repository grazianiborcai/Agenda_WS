package br.com.mind5.business.storeProspect.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeProspect.info.StoprosInfo;
import br.com.mind5.common.StringValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StoprosCheckSafePhone extends ModelCheckerTemplateSimple<StoprosInfo> {

	public StoprosCheckSafePhone(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoprosInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.prospectPhone == null)
			return super.SUCCESS;
		
		if (StringValidator.validateSafe(recordInfo.prospectPhone) == super.SUCCESS)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_CONTAIN_INVALID_CHAR);
		builder.addParam01(SystemCode.STORE_PROSPECT);
		builder.addParam02(SystemCode.GEN_PHONE_NUMBER);

		return builder.build();
	}
}
