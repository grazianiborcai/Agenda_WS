package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;

public final class OrdapaCheckHasOrderId extends ModelCheckerTemplateSimple<OrdapaInfo> {

	public OrdapaCheckHasOrderId(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OrdapaInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.payordemData == null)			
			return super.FAILED;
		
		
		if (recordInfo.payordemData.idOrderPartner == null)			
			return super.FAILED;

		
		return super.SUCCESS;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_MANDATORY_FIELD_EMPTY_M);
		builder.addParam01(SystemCode.PAGARME_ORDER);

		return builder.build();
	}
}
