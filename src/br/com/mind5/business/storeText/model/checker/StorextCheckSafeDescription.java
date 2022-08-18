package br.com.mind5.business.storeText.model.checker;

import java.sql.Connection;

import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.common.StringValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class StorextCheckSafeDescription extends ModelCheckerTemplateSimple<StorextInfo> {

	public StorextCheckSafeDescription(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StorextInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.description == null)
			return super.SUCCESS;
		
		if (StringValidator.validateSafe(recordInfo.description) == super.SUCCESS)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_CONTAIN_INVALID_CHAR);
		builder.addParam01(SystemCode.STORE_TEXT);
		builder.addParam02(SystemCode.GEN_DESCRIPTION);

		return builder.build();
	}
}
