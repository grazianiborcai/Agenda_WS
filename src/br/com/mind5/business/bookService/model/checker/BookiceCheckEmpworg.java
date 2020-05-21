package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.business.employeeWorkTimeRange.model.checker.EmpworgCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class BookiceCheckEmpworg extends ModelCheckerTemplateForwardV2<BookiceInfo, EmpworgInfo> {
	
	public BookiceCheckEmpworg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EmpworgInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpworgCheckExist(option);
	}
	
	
	
	@Override protected EmpworgInfo toForwardClass(BookiceInfo baseRecord) {
		return EmpworgInfo.copyFrom(baseRecord);
	}
}
