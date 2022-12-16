package br.com.mind5.config.payPartnerConfig.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.config.common.ConfigValue;
import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class PayrconfCheckStoparEnabled extends ModelCheckerTemplateSimple<PayrconfInfo> {

	public PayrconfCheckStoparEnabled(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PayrconfInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.stoparCreation.equals(ConfigValue.ENABLED.getConfigValue()) )			
			return super.SUCCESS;
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.PAY_PARTNER_CONFIG);

		return builder.build();
	}
}
