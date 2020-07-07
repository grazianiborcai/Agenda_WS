package br.com.mind5.business.notes.model.checker;

import br.com.mind5.business.notes.info.NotesInfo;
import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.owner.model.checker.OwnerCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class NotesCheckOwner extends ModelCheckerTemplateForwardV2<NotesInfo, OwnerInfo> {
	
	public NotesCheckOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<OwnerInfo> getCheckerHook(ModelCheckerOption option) {
		return new OwnerCheckExist(option);
	}
	
	
	
	@Override protected OwnerInfo toForwardClass(NotesInfo baseRecord) {
		return OwnerInfo.copyFrom(baseRecord);
	}
}
