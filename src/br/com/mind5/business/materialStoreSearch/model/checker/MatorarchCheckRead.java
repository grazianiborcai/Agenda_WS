package br.com.mind5.business.materialStoreSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatorarchCheckRead extends ModelCheckerTemplateSimpleV2<MatorarchInfo> {

	public MatorarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatorarchInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner    <= 0	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username	== null		)		
			
			return super.FAILED;
		
		
		if ( recordInfo.codMat   <= 0	&&
			 recordInfo.codStore <= 0		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_STORE_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
