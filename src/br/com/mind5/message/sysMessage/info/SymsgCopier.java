package br.com.mind5.message.sysMessage.info;


import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopierTemplate;

public final class SymsgCopier {
	public static SymsgInfo copyFromBookice(BookiceInfo source) {
		InfoCopierTemplate<SymsgInfo, BookiceInfo> copier = new SymsgCopyBookice();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SymsgInfo> copyFromBookice(List<BookiceInfo> sources) {
		InfoCopierTemplate<SymsgInfo, BookiceInfo> copier = new SymsgCopyBookice();
		return copier.makeCopy(sources);
	}
	
	
	
	public static SymsgInfo copyFromCartem(CartemInfo source) {
		InfoCopierTemplate<SymsgInfo, CartemInfo> copier = new SymsgCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<SymsgInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopierTemplate<SymsgInfo, CartemInfo> copier = new SymsgCopyCartem();
		return copier.makeCopy(sources);
	}
}
