package br.com.mind5.file.sysFileImage.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FimgysCheckDelete extends ModelCheckerTemplateSimple<FimgysInfo> {

	public FimgysCheckDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgysInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codFileImg	<= 0	||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
			
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_MANDATORY_FIELD_EMPTY;
	}
}
