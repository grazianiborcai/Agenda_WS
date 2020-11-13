package br.com.mind5.business.materialList.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatlisCheckSearch extends ModelCheckerTemplateSimple<MatlisInfo> {

	public MatlisCheckSearch(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatlisInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.username	== null ||
			 recordInfo.codLanguage == null		)			
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_LIST_MANDATORY_FIELD_EMPTY;
	}
}
