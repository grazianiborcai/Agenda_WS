package br.com.mind5.business.employeeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopier;

public final class EmplargCopier {
	public static EmplargInfo copyFromBookice(BookiceInfo source) {
		InfoCopier<EmplargInfo, BookiceInfo> copier = new EmplargCopyBookice();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplargInfo> copyFromBookice(List<BookiceInfo> sources) {
		InfoCopier<EmplargInfo, BookiceInfo> copier = new EmplargCopyBookice();
		return copier.makeCopy(sources);
	}
	
	
	
	public static EmplargInfo copyFromCartem(CartemInfo source) {
		InfoCopier<EmplargInfo, CartemInfo> copier = new EmplargCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmplargInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopier<EmplargInfo, CartemInfo> copier = new EmplargCopyCartem();
		return copier.makeCopy(sources);
	}
}
