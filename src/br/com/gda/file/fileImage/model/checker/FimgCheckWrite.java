package br.com.gda.file.fileImage.model.checker;

import java.sql.Connection;

import br.com.gda.common.SystemCode;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimpleV2;

public final class FimgCheckWrite extends ModelCheckerTemplateSimpleV2<FimgInfo> {

	public FimgCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgInfo recordInfo, Connection conn, String schemaName) {	
		if (   recordInfo.codOwner 		<= 0 	
			|| recordInfo.fileImgData	== null
			|| recordInfo.codLanguage	== null
			|| recordInfo.username		== null	)
			
			return super.FAILED;
		
		
		if (   recordInfo.codPerson 	<= 0 	
			&& recordInfo.codStore		<= 0
			&& recordInfo.codOwnerRef	<= 0
			&& recordInfo.codMat		<= 0)
			
			return super.FAILED;
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_MANDATORY_FIELD_EMPTY;
	}
}
