package br.com.mind5.security.username.info;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class UsernameCopyBookice extends InfoCopierTemplate<UsernameInfo, BookiceInfo> {
	
	public UsernameCopyBookice() {
		super();
	}
	
	
	
	@Override protected UsernameInfo makeCopyHook(BookiceInfo source) {
		UsernameInfo result = new UsernameInfo();
		
		result.codOwner = source.codOwner;	
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
