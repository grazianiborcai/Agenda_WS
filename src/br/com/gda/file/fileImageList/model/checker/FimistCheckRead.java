package br.com.gda.file.fileImageList.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

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
		     recordInfo.codOwnerRef	<= 0 &&
			 recordInfo.codMat		<= 0	)
				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_LIST_MANDATORY_FIELD_EMPTY;
	}
}
