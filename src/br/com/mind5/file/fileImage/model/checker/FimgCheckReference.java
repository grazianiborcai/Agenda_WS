package br.com.mind5.file.fileImage.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class FimgCheckReference extends ModelCheckerTemplateSimple<FimgInfo> {

	public FimgCheckReference(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FimgInfo recordInfo, Connection conn, String schemaName) {	
		if (countReference(recordInfo) == 1)
			return super.SUCCESS;

				
		return super.FAILED;
	}
	
	
	
	private int countReference(FimgInfo recordInfo) {
		int counter = 0;
		
		if ( recordInfo.codPerson 	> 0 )
			counter = counter + 1;
				
		if ( recordInfo.codStore 	> 0 )
			counter = counter + 1;		
				
		if ( recordInfo.codEmployee > 0 )
			counter = counter + 1;		
		
		if ( recordInfo.codCustomer > 0 )
			counter = counter + 1;	

		if ( recordInfo.codOwnerRef	> 0 )
			counter = counter + 1;		
		
		if ( recordInfo.codMat 		> 0 )
			counter = counter + 1;		
		
		if ( recordInfo.codUser 	> 0 )
			counter = counter + 1;	
		
		if ( recordInfo.codGroup 	> 0 )
			counter = counter + 1;	
		
		return counter;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.FILE_IMG_ILLEGAL_REFERENCE;
	}
}
