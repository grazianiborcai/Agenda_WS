package br.com.mind5.business.notes.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.model.checker.CusCheckExist;
import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class NotesCheckCus extends ModelCheckerTemplateForwardV2<NotesInfo, CusInfo> {
	
	public NotesCheckCus(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<CusInfo> getCheckerHook(ModelCheckerOption option) {
		return new CusCheckExist(option);
	}
	
	
	
	@Override protected CusInfo toForwardClass(NotesInfo baseRecord) {
		return CusInfo.copyFrom(baseRecord);
	}
}
