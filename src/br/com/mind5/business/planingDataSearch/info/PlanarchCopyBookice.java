package br.com.mind5.business.planingDataSearch.info;


import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PlanarchCopyBookice extends InfoCopierTemplate<PlanarchInfo, BookiceInfo> {
	
	public PlanarchCopyBookice() {
		super();
	}
	
	
	
	@Override protected PlanarchInfo makeCopyHook(BookiceInfo source) {
		PlanarchInfo result = PlanarchInfo.copyFrom(source);		
		result.beginTimeSel = result.beginTime;
		result.endTimeSel = result.endTime;

		return result;
	}
}
