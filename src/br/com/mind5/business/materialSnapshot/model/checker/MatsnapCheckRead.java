package br.com.mind5.business.materialSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class MatsnapCheckRead extends ModelCheckerTemplateSimple<MatsnapInfo> {

	public MatsnapCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatsnapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codSnapshot <= 0 	||
			 recordInfo.codMat 		<= 0 	||
			 recordInfo.codLanguage == null	||
			 recordInfo.username  	== null		)		
			
			return super.FAILED;		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SNAPSHOT_MANDATORY_FIELD_EMPTY;
	}
}
