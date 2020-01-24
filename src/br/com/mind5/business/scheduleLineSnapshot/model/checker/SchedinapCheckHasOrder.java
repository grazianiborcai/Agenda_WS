package br.com.mind5.business.scheduleLineSnapshot.model.checker;

import java.sql.Connection;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class SchedinapCheckHasOrder extends ModelCheckerTemplateSimpleV2<SchedinapInfo> {

	public SchedinapCheckHasOrder(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(SchedinapInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOrder <= 0 )			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.SCHEDULE_SNAPSHOT_HAS_NO_ORDER;
	}
}
