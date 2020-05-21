package br.com.mind5.business.planingDataSearch.info;


import java.util.List;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.info.InfoCopier;

public final class PlanarchCopier {	
	public static PlanarchInfo copyFromBookice(BookiceInfo source) {
		InfoCopier<PlanarchInfo, BookiceInfo> copier = new PlanarchCopyBookice();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PlanarchInfo> copyFromBookice(List<BookiceInfo> sources) {
		InfoCopier<PlanarchInfo, BookiceInfo> copier = new PlanarchCopyBookice();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PlanarchInfo copyFromCartem(CartemInfo source) {
		InfoCopier<PlanarchInfo, CartemInfo> copier = new PlanarchCopyCartem();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PlanarchInfo> copyFromCartem(List<CartemInfo> sources) {
		InfoCopier<PlanarchInfo, CartemInfo> copier = new PlanarchCopyCartem();
		return copier.makeCopy(sources);
	}
}
