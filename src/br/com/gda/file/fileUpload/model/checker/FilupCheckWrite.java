package br.com.gda.file.fileUpload.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FilupCheckWrite extends ModelCheckerTemplateSimple<FilupInfo> {

	public FilupCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FilupInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 	
			|| recordInfo.fileImgFullName	== null
			|| recordInfo.codLanguage		== null
			|| recordInfo.username			== null	)
			
			return super.FAILED;
		
		
		if (   recordInfo.codPerson 	<= 0 	
			&& recordInfo.codCompany	<= 0
			&& recordInfo.codMat		<= 0)
			
			return super.FAILED;
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.FILE_IMG_MANDATORY_FIELD_EMPTY;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.FILE_IMG_MANDATORY_FIELD_EMPTY;
	}
}
