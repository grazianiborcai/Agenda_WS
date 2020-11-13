package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckEmp extends ModelCheckerTemplateForward<BookiceInfo, EmpInfo> {
	
	public BookiceCheckEmp(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpCheckExist(option);
	}
	
	
	
	@Override protected EmpInfo toForwardClass(BookiceInfo baseRecord) {
		return EmpInfo.copyFrom(baseRecord);
	}
}
