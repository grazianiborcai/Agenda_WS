package br.com.mind5.business.notes.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class NotesCheckCus extends ModelCheckerTemplateForward<NotesInfo, CusInfo> {
	
	public NotesCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(NotesInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
