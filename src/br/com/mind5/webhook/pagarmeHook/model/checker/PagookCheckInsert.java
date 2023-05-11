package br.com.mind5.webhook.pagarmeHook.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookCheckInsert extends ModelCheckerTemplateSimple<PagookInfo> {

	public PagookCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(PagookInfo recordInfo, Connection conn, String schemaName) {			
		if ( recordInfo.id    == null ||
			 recordInfo.type  == null ||
			 recordInfo.data  == null)		
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.WHOOK_PAGARME);

		return builder.build();
	}
}
