package br.com.mind5.file.sysFileImageSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FimgysarchCheckReadGroup extends ModelCheckerTemplateSimple<FimgysarchInfo> {

	public FimgysarchCheckReadGroup(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgysarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codGroup		<= 0	||	
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SYS_FILE_IMG_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
