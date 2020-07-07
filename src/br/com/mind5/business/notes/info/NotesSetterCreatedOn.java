package br.com.mind5.business.notes.info;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoSetterTemplate;

public final class NotesSetterCreatedOn extends InfoSetterTemplate<NotesInfo> {
	
	@Override protected NotesInfo setAttrHook(NotesInfo recordInfo) {	
		recordInfo.createdOn = DefaultValue.localDateTimeNow();
		return recordInfo;
	}
}
