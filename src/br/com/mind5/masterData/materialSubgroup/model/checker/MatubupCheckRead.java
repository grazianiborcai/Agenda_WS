package br.com.mind5.masterData.materialSubgroup.model.checker;

import java.sql.Connection;

import br.com.mind5.common.SystemCode;
import br.com.mind5.masterData.materialSubgroup.info.MatubupInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class MatubupCheckRead extends ModelCheckerTemplateSimpleV2<MatubupInfo> {

	public MatubupCheckRead(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatubupInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codSubgroup <= 0 	||
			 recordInfo.codLanguage == null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.MAT_SUBGROUP_MANDATORY_FIELD_EMPTY;
	}
}
