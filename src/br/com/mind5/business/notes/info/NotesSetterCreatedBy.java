package br.com.mind5.business.notes.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class NotesSetterCreatedBy extends InfoSetterTemplate<NotesInfo> {
	
	@Override protected NotesInfo setAttrHook(NotesInfo recordInfo) {		
		recordInfo.createdBy = recordInfo.lastChangedBy;
		return recordInfo;
	}
}
