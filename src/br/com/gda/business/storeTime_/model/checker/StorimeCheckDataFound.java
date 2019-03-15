package br.com.gda.business.storeTime_.model.checker;

import java.sql.Connection;

import br.com.gda.business.storeTime_.info.StorimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class StorimeCheckDataFound extends ModelCheckerTemplateSimple<StorimeInfo> {

	public StorimeCheckDataFound() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(StorimeInfo recordInfo, Connection conn, String schemaName) {	
		boolean isStowotmEmpty = super.SUCCESS;
		
		if (recordInfo.stowotms == null)
			isStowotmEmpty = super.FAILED;
		
		if (recordInfo.stowotms.isEmpty())
			isStowotmEmpty = super.FAILED;
		
		
		if (isStowotmEmpty == super.FAILED)				
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.DATA_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.DATA_NOT_FOUND;
	}
}
