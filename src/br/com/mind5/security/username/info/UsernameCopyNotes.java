package br.com.mind5.security.username.info;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyNotes extends InfoCopierTemplate<UsernameInfo, NotesInfo> {
	
	public UsernameCopyNotes() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(NotesInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
