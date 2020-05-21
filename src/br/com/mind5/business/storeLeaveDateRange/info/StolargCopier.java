package br.com.mind5.business.storeLeaveDateRange.info;

import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopier;

public final class StolargCopier {
	public static StolargInfo copyFromBookice(BookiceInfo source) {
		InfoCopier<StolargInfo, BookiceInfo> copier = new StolargCopyBookice();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolargInfo> copyFromBookice(List<BookiceInfo> sources) {
		InfoCopier<StolargInfo, BookiceInfo> copier = new StolargCopyBookice();
		return copier.makeCopy(sources);
	}
	
	
	
	public static StolargInfo copyFromCartem(CartemInfo source) {
		InfoCopier<StolargInfo, CartemInfo> copier = new StolargCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<StolargInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopier<StolargInfo, CartemInfo> copier = new StolargCopyCartem();
		return copier.makeCopy(sources);
	}
}
