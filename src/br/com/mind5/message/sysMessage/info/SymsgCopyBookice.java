package br.com.mind5.message.sysMessage.info;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SymsgCopyBookice extends InfoCopierTemplate<SymsgInfo, BookiceInfo> {
	
	public SymsgCopyBookice() {
		super();
	}
	
	
	
	@Override protected SymsgInfo makeCopyHook(BookiceInfo source) {	
		return source.symsgData;
	}
}
