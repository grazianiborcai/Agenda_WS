package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.planingDataSearch.info.PlanarchCopier;
import br.com.mind5.business.planingDataSearch.info.PlanarchInfo;
import br.com.mind5.business.planingDataSearch.model.checker.PlanarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckPlanarch extends ModelCheckerTemplateForward<BookiceInfo, PlanarchInfo> {
	
	public BookiceCheckPlanarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PlanarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PlanarchCheckExist(option);
	}
	
	
	
	@Override protected PlanarchInfo toForwardClass(BookiceInfo baseRecord) {
		return PlanarchCopier.copyFromBookice(baseRecord);
	}
}
