package br.com.mind5.business.notes.model.checker;

import java.sql.Connection;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimpleV2;

public final class NotesCheckWrite extends ModelCheckerTemplateSimpleV2<NotesInfo> {

	public NotesCheckWrite(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(NotesInfo recordInfo, Connection conn, String schemaName) {	
		if ( recordInfo.codOwner 	<= 0 	||
			 recordInfo.codNote		<= 0	||
			 recordInfo.note		== null ||
			 recordInfo.codLanguage	== null	||
			 recordInfo.username	== null		)
			
			return super.FAILED;
		
		
		return super.SUCCESS;
	}
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.NOTES_MANDATORY_FIELD_EMPTY;
	}
}
