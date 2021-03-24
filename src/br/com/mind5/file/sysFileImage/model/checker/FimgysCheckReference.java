package br.com.mind5.file.sysFileImage.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FimgysCheckReference extends ModelCheckerTemplateSimple<FimgysInfo> {

	public FimgysCheckReference(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgysInfo recordInfo, Connection conn, String schemaName) {	
		if (countReference(recordInfo) == 1)
			return super.SUCCESS;

				
		return super.FAILED;
	}
	
	
	
	private int countReference(FimgysInfo recordInfo) {
		int counter = 0;

		if ( recordInfo.codGroup	> 0 )
			counter = counter + 1;
		
		return counter;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_ILLEGAL_REFERENCE;
	}
}
