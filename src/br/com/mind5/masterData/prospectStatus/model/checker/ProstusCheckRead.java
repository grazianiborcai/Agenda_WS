package br.com.mind5.masterData.prospectStatus.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class ProstusCheckRead extends ModelCheckerTemplateSimpleV2<ProstusInfo> {

	public ProstusCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(ProstusInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codLanguage 		== null ||
			 recordInfo.codProspectStatus  	== null		)		
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PROSP_STATUS_MANDATORY_FIELD_EMPTY;
	}
}
