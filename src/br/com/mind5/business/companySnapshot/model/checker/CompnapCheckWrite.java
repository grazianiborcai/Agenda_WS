package br.com.mind5.business.companySnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class CompnapCheckWrite extends ModelCheckerTemplateSimple<CompnapInfo> {

	public CompnapCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(CompnapInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 	 <= 0	
			|| recordInfo.codCompany <= 0  )
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.COMPANY_SNAP_MANDATORY_FIELD_EMPTY;
	}
}
