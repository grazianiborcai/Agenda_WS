package br.com.mind5.business.material.model.checker;

import java.sql.Connection;

import br.com.mind5.business.masterData.info.common.MatUnit;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatCheckServiceUnit extends ModelCheckerTemplateSimpleV2<MatInfo> {

	public MatCheckServiceUnit(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		if (recordInfo.codUnit == null)
			return super.FAILED;
		
		
		if (MatUnit.HOUR.getCodUnit().equals(recordInfo.codUnit))	
			return super.SUCCESS;		
		
		
		if (MatUnit.MINUTE.getCodUnit().equals(recordInfo.codUnit))					
			return super.SUCCESS;	
		
		
		return super.FAILED;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SERVICE_UNIT_INCONSISTENCY;
	}
}
