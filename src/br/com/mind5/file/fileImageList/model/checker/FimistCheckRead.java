package br.com.mind5.file.fileImageList.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class FimistCheckRead extends ModelCheckerTemplateSimpleV2<FimistInfo> {

	public FimistCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimistInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner 	<= 0 	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		if ( recordInfo.codPerson 	<= 0 &&
			 recordInfo.codStore	<= 0 &&
			 recordInfo.codCustomer	<= 0 &&
			 recordInfo.codEmployee	<= 0 &&
		     recordInfo.codOwnerRef	<= 0 &&
			 recordInfo.codMat		<= 0	)
				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_LIST_MANDATORY_FIELD_EMPTY;
	}
}
