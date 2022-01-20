package br.com.mind5.business.petSearch.model.checker;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.decisionTree.RootPetarchSelectPetStore;
import br.com.mind5.common.SystemCode;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchCheckExistPetStore extends ModelCheckerTemplateAction<PetarchInfo, PetarchInfo> {
	
	public PetarchCheckExistPetStore(ModelCheckerOption option) {
		super(option, PetarchInfo.class);
	}
	

	
	@Override protected ActionStd<PetarchInfo> buildActionHook(DeciTreeOption<PetarchInfo> option) {		
		ActionStd<PetarchInfo> select = new RootPetarchSelectPetStore(option).toAction();			
		return select;
	}
	
	
	
	@Override protected int getCodMsgOnResultTrueHook() {
		return SystemCode.PET_SEARCH_ALREADY_EXIST;
	}	
	
	
	
	@Override protected int getCodMsgOnResultFalseHook() {
		return SystemCode.PET_SEARCH_NOT_FOUND;
	}
}
