package br.com.mind5.business.bookService.model.checker;

import br.com.mind5.business.bookService.info.BookiceInfo;
import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.business.employeeMaterial.model.checker.EmpmatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class BookiceCheckEmpmat extends ModelCheckerTemplateForward<BookiceInfo, EmpmatInfo> {
	
	public BookiceCheckEmpmat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EmpmatInfo> getCheckerHook(ModelCheckerOption option) {
		return new EmpmatCheckExist(option);
	}
	
	
	
	@Override protected EmpmatInfo toForwardClass(BookiceInfo baseRecord) {
		return EmpmatInfo.copyFrom(baseRecord);
	}
}
