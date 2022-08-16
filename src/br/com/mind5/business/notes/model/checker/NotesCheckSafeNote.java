package br.com.mind5.business.notes.model.checker;

import java.sql.Connection;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.common.StringValidator;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessageBuilder;
import br.com.mind5.message.sysMessage.info.SymsgInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple;

public final class NotesCheckSafeNote extends ModelCheckerTemplateSimple<NotesInfo> {

	public NotesCheckSafeNote(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(NotesInfo recordInfo, Connection conn, String schemaName) {
		if (recordInfo.note == null)
			return super.SUCCESS;
		
		if (StringValidator.validateSafe(recordInfo.note) == super.SUCCESS)
			return super.SUCCESS;
		
		return super.FAILED;
	}
	
	
	
	@Override protected SymsgInfo getSymsgOnResultFalseHook(Connection dbConn, String dbSchema, String codLangu) {
		SystemMessageBuilder builder = new SystemMessageBuilder(dbConn, dbSchema, codLangu, SystemCode.GEN_P1_P2_CONTAIN_INVALID_CHAR);
		builder.addParam01(SystemCode.NOTES);
		builder.addParam02(SystemCode.GEN_NOTE);

		return builder.build();
	}
}
