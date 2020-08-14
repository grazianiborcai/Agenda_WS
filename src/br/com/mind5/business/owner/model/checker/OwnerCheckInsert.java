package br.com.mind5.business.owner.model.checker;

import java.sql.Connection;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class OwnerCheckInsert extends ModelCheckerTemplateSimpleV2<OwnerInfo> {

	public OwnerCheckInsert(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codBusiness <= 0	||
			 recordInfo.codLanguage == null ||
			 recordInfo.personData 	== null ||
			 recordInfo.companyData == null ||
			 recordInfo.codLanguage == null 	)
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.OWNER_MANDATORY_FIELD_EMPTY;
	}
}
