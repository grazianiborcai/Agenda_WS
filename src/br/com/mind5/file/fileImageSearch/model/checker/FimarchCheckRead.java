package br.com.mind5.file.fileImageSearch.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FimarchCheckRead extends ModelCheckerTemplateSimple<FimarchInfo> {

	public FimarchCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimarchInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codOwner		<= 0	||
			recordInfo.codLanguage 	== null		)
			
			return super.FAILED;
		
		
		if (countReference(recordInfo) == 1)
			return super.SUCCESS;

				
		return super.FAILED;
	}
	
	
	
	private int countReference(FimarchInfo recordInfo) {
		int counter = 0;
		
		if ( recordInfo.codPerson 	> 0 )
			counter = counter + 1;
				
		if ( recordInfo.codStore 	> 0 )
			counter = counter + 1;		
				
		if ( recordInfo.codEmployee > 0 )
			counter = counter + 1;		

		if ( recordInfo.codOwnerRef	> 0 )
			counter = counter + 1;		
		
		if ( recordInfo.codMat 		> 0 )
			counter = counter + 1;		
		
		if ( recordInfo.codUser		> 0 )
			counter = counter + 1;	
		
		return counter;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_SEARCH_MANDATORY_FIELD_EMPTY;
	}
}
