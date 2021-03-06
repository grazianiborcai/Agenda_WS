package br.com.mind5.payment.systemPartnerSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class SysparchCheckRead extends ModelCheckerTemplateSimple<SysparchInfo> {

	public SysparchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SysparchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.username			== null ||
			 recordInfo.codLanguage 		== null		)			
			return super.FAILED;
		
		
		if ( recordInfo.codPayPartner 		<= 0    &&
			 recordInfo.idPayPartnerSystem	== null		)			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_PAYPAR_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
