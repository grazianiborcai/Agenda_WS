package br.com.gda.file.fileImage.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FimgCheckWrite extends ModelCheckerTemplateSimple<FimgInfo> {

	public FimgCheckWrite() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(FimgInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 			<= 0 	
			|| recordInfo.fileImgData		== null
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
