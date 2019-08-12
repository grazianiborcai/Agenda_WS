package br.com.gda.business.schedule.model.checker;

import java.sql.Connection;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class SheduCheckIsService extends ModelCheckerTemplateSimple<ScheduInfo> {

	public SheduCheckIsService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(ScheduInfo recordInfo, Connection conn, String schemaName) {	
		if(recordInfo.matData == null)
			return super.FAILED;
		
		if (recordInfo.matData.codMatCateg == MatCateg.SERVICE.getCodMatCateg())
			return super.SUCCESS;		
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.SCHEDULE_MATERIAL_IS_NOT_SERVICE;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.SCHEDULE_MATERIAL_IS_NOT_SERVICE;
	}
}
