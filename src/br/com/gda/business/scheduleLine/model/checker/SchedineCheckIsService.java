package br.com.gda.business.scheduleLine.model.checker;

import java.sql.Connection;

import br.com.gda.business.masterData.info.common.MatCateg;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerTemplateSimple_;

public final class SchedineCheckIsService extends ModelCheckerTemplateSimple_<SchedineInfo> {

	public SchedineCheckIsService() {
		super();
	}
	
	
	
	@Override protected boolean checkHook(SchedineInfo recordInfo, Connection conn, String schemaName) {	
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
