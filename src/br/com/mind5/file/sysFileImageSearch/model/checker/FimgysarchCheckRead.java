package br.com.mind5.file.sysFileImageSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FimgysarchCheckRead extends ModelCheckerTemplateSimple<FimgysarchInfo> {

	public FimgysarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgysarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		if (countReference(recordInfo) == 1)
			return super.SUCCESS;

				
		return super.FAILED;
	}
	
	
	
	private int countReference(FimgysarchInfo recordInfo) {
		int counter = 0;

		if ( recordInfo.codGroup	> 0 )
			counter = counter + 1;	
		
		return counter;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
